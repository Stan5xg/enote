package db;

import com.epam.enote.config.AppConfig;
import com.epam.enote.entities.Note;
import com.epam.enote.entities.Notepad;
import com.epam.enote.entities.User;
import com.epam.enote.repos.NoteRepo;
import com.epam.enote.repos.NotepadRepo;
import com.epam.enote.repos.UserRepo;
import org.h2.tools.Server;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class NoteRepoTest {

    public static final int DEFAULT_ID = 1;
    public static final int NOT_EXISTENT_ID = 99;
    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private NotepadRepo notepadRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private NoteRepo noteRepo;

    ConfigurableApplicationContext configurableApplicationContext;

    @Before
    public void setUp(){
        configurableApplicationContext = new ClassPathXmlApplicationContext("db/testData.xml");
        userRepo.deleteAll();
        notepadRepo.deleteAll();
        Note note = (Note) configurableApplicationContext.getBean("note");

        if (!noteRepo.existsById(DEFAULT_ID)) {
            noteRepo.save(note);
        }
    }
//
//    @Test
//    public void name() {
//        System.out.println();
//    }

//    @Test
//    public void name() throws SQLException, InterruptedException {
//        Server webServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082");
//        webServer.start();
//        while (true) ;
//    }


    @Test
    public void testNoteRepo() {
        assertNotNull("appContext should not be null", appContext);
        assertNotNull("userRepo should not be null", noteRepo);
    }

    @Test
    public void testFindAll() {
        Note anotherNote = (Note) configurableApplicationContext.getBean("note2");
        noteRepo.save(anotherNote);

//        List<Note> notes = noteRepo.findAll();
//        assertTrue(notes.size() == 2);
//    }

//    @Test(expected = NoSuchElementException.class)
//    public void testNoFindById() {
//        userRepo.findById(NOT_EXISTENT_ID+99999);
//    }
//
//    @Test
//    public void testFindById() {
//        assertNotNull(userRepo.findById(DEFAULT_ID));
//    }
//
//
//    @Test
//    public void testUpdate() {
//        Note noteBean = (Note) configurableApplicationContext.getBean("note");
//        Note note = noteRepo.findAllByTitle(noteBean.getTitle()).get(0);
//        note.setContent("mew mew mew mew mew mew mew mew");
//        noteRepo.saveAndFlush(note);
//        Note noteFromDb = noteRepo.getOne(note.getId());
//        assertEquals(note, noteFromDb);
//    }

//    @Test
//    public void testDelete() {
//        User user = userRepo.findOneByUsername("Stan");
//        assertNotNull(userRepo.findById(user.getId()));
//        userRepo.delete(user);
//        assertEquals(userRepo.findById(user.getId()), Optional.empty());
//
//    }
}
