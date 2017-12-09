package db;

import com.epam.enote.config.AppConfig;
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

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class GeneralTest {

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private UserRepo userRepo;

    ConfigurableApplicationContext configurableApplicationContext;

    @Before
    public void setUp(){
        configurableApplicationContext = new ClassPathXmlApplicationContext("db/testData.properties");
    }

    @Test
    public void testUserRepo() {
        assertNotNull("appContext should not be null", appContext);
        assertNotNull("userRepo should not be null", userRepo);
    }




}
