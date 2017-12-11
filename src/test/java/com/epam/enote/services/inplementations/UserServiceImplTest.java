package com.epam.enote.services.inplementations;

import com.epam.enote.config.AppConfig;
import com.epam.enote.repos.UserRepo;
import com.epam.enote.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UserServiceImplTest {

    private ConfigurableApplicationContext ctx;
    private UserService userService;

    @Mock
    private UserRepo userRepo;

    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("db/testData.xml");
        userService=new UserServiceImpl(userRepo);
    }

    @Test
    public void create() throws Exception {

    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void getById() throws Exception {
    }

    @Test
    public void getByName() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
    }

}