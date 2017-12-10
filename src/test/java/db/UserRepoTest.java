package db;

import com.epam.enote.config.AppConfig;
import com.epam.enote.entities.User;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class UserRepoTest {

    public static final int DEFAULT_ID = 1;
    public static final int NOT_EXISTENT_ID = 99;
    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private UserRepo userRepo;

    ConfigurableApplicationContext configurableApplicationContext;

    @Before
    public void setUp() {
        configurableApplicationContext = new ClassPathXmlApplicationContext("db/testData.xml");

        User user = (User) configurableApplicationContext.getBean("user");
        if (!userRepo.existsById(DEFAULT_ID)) {
            userRepo.save(user);
        }
    }

    @Test
    public void testUserRepo() {
        assertNotNull("appContext should not be null", appContext);
        assertNotNull("userRepo should not be null", userRepo);
    }

    @Test
    public void testFindAll() throws SQLException {
        userRepo.save((User) configurableApplicationContext.getBean("user2"));
        List<User> users = userRepo.findAll();
        assertTrue(users.size() == 2);
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoFindById() {
        userRepo.findById(NOT_EXISTENT_ID).get();
    }

    @Test
    public void testFindById() {
        assertNotNull(userRepo.findById(DEFAULT_ID).get());
    }


    @Test
    public void testUpdate() {
        User user = userRepo.findOneByUsername("Stan");
        user.setPasswordHash("new");
        userRepo.saveAndFlush(user);

        assertEquals("new", userRepo.findOneByUsername(user.getUsername()).getPasswordHash());
    }

    @Test
    public void testDelete() {
        User user = userRepo.findOneByUsername("Stan");
        assertNotNull(userRepo.findById(user.getId()));
        userRepo.delete(user);
        assertEquals(userRepo.findById(user.getId()), Optional.empty());
    }
}
