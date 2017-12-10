package db;

import com.epam.enote.config.AppConfig;
import com.epam.enote.entities.Note;
import com.epam.enote.entities.User;
import com.epam.enote.repos.NoteRepo;
import com.epam.enote.repos.UserRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    private NoteRepo noteRepo;

    ConfigurableApplicationContext configurableApplicationContext;

    @Before
    public void setUp() {
        configurableApplicationContext = new ClassPathXmlApplicationContext("db/testData.xml");

        Note note = (Note) configurableApplicationContext.getBean("note");
        if (!noteRepo.existsById(DEFAULT_ID)) {
            noteRepo.save(note);
        }
    }

    @Test
    public void testUserRepo() {
        assertNotNull("appContext should not be null", appContext);
        assertNotNull("userRepo should not be null", noteRepo);
    }

//    @Test
//    public void testFindAll() throws SQLException {
//        noteRepo.save((Note) configurableApplicationContext.getBean("note2"));
//        List<User> users = userRepo.findAll();
//        assertTrue(users.size() == 2);
//    }
//
//    @Test(expected = NoSuchElementException.class)
//    public void testNoFindById() {
//        userRepo.findById(NOT_EXISTENT_ID).get();
//    }
//
//    @Test
//    public void testFindById() {
//        assertNotNull(userRepo.findById(DEFAULT_ID).get());
//    }
//
//
//    @Test
//    public void testUpdate() {
//        User user = userRepo.findOneByUsername("Stan");
//        user.setPasswordHash("new");
//        userRepo.saveAndFlush(user);
//        assertEquals("new", user.getPasswordHash());
//    }
//
//    @Test
//    public void testDelete() {
//        User user = userRepo.findOneByUsername("Stan");
//        assertNotNull(userRepo.findById(user.getId()));
//        userRepo.delete(user);
//        assertEquals(userRepo.findById(user.getId()), Optional.empty());
//
//    }
}
