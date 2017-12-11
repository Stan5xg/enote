package db;

import com.epam.enote.config.AppConfig;
import com.epam.enote.entities.Notepad;
import com.epam.enote.entities.User;
import com.epam.enote.repos.NotepadRepo;
import com.epam.enote.repos.UserRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.constraints.AssertTrue;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class NotepadRepoTest {

    public static final int DEFAULT_ID = 1;
    public static final int NOT_EXISTENT_ID = 99;
    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private NotepadRepo notepadRepo;

    @Autowired
    private UserRepo userRepo;

    ConfigurableApplicationContext configurableApplicationContext;
    private Notepad notepad;
    private User user;

    @Before
    public void setUp() {
        configurableApplicationContext = new ClassPathXmlApplicationContext("db/testData.xml");
        notepad = configurableApplicationContext.getBean(Notepad.class);
        user = notepad.getUser();
        user.addNotepad(notepad);
        userRepo.save(user);
    }

    @Test
    public void testUserRepo() {
        assertNotNull("appContext should not be null", appContext);
        assertNotNull("userRepo should not be null", notepadRepo);
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoFindById() {
        notepadRepo.findById(NOT_EXISTENT_ID).get();
    }

    @Test
    public void testFindById() {
        assertNotNull(notepadRepo.findAllByUserId(user.getId()));
    }


    @Test
    public void testUpdate() {
        Notepad notepad = notepadRepo.findAllByUserId(user.getId()).get(0);
        notepad.setName("new");
        notepadRepo.saveAndFlush(notepad);
        assertEquals("new", notepadRepo.findAllByUserId(user.getId()).get(0).getName());
    }

    @Test
    public void testDelete() {
        List<Notepad> notepads = notepadRepo.findAllByUserId(DEFAULT_ID);
        int before = notepads.size();
        assertTrue(before > 0);
        notepadRepo.delete(notepads.get(0));
        int after = notepadRepo.findAllByUserId(DEFAULT_ID).size();
        assertTrue(after < before);
    }
}
