package db;

import com.epam.enote.config.AppConfig;
import com.epam.enote.entities.User;
import com.epam.enote.repos.NoteRepo;
import com.epam.enote.repos.NotepadRepo;
import com.epam.enote.repos.TagRepo;
import com.epam.enote.repos.UserRepo;
import org.junit.After;
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

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class GeneralTest {

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TagRepo tagRepo;

    @Autowired
    private NoteRepo noteRepo;

    @Autowired
    private NotepadRepo notepadRepo;


    ConfigurableApplicationContext configurableApplicationContext;

    @Before
    public void setUp(){
        configurableApplicationContext = new ClassPathXmlApplicationContext("db/testData.xml");
        userRepo.deleteAll();
        tagRepo.deleteAll();
        noteRepo.deleteAll();
        notepadRepo.deleteAll();
        userRepo.save(configurableApplicationContext.getBean(User.class));
//        notepadRepo.save(configurableApplicationContext.getBean(Notepad.class));
//        noteRepo.save(configurableApplicationContext.getBean(Note.class));
//        tagRepo.save(configurableApplicationContext.getBean(Tag.class));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testUserRepo() {
        assertNotNull("appContext should not be null", appContext);
        assertNotNull("userRepo should not be null", userRepo);
    }

    @Test
    public void newTest() throws SQLException {
        System.out.println(userRepo.findAll().size());
        List<User> users = userRepo.findAll();
        System.out.println(users);
    }
}
