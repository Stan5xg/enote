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

    @Test
    public void testUserRepo() {
        assertNotNull("appContext should not be null", appContext);
    }

}
