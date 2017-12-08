package db;

import com.epam.enote.config.AppConfig;
import com.epam.enote.entities.User;
import db.config.TestDataConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDataConfig.class, AppConfig.class})
public class TestJdbc {

//    @Autowired
//    @Qualifier("userTemplateRepo")
//    UserRepo userRepo;

    @Autowired
    private ApplicationContext appContext;

    @Before
    public void setUp(){
    }

    @Test
    public void test() {
        JdbcTemplate template = appContext.getBean(JdbcTemplate.class);
        System.out.println(template.queryForList("SELECT * FROM `user`;"));
    }




}
