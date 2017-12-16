package com.epam.enote.services.implementations;

import com.epam.enote.config.AppConfig;
import com.epam.enote.entities.User;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

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
    public void create() {
        User user = (User) ctx.getBean("user");
        when(userRepo.save(user)).thenReturn(user);
        userService.create(user);
        verify(userRepo, times(1)).save(any());
    }

    @Test
    public void update() {
        User user = (User) ctx.getBean("user");
        when(userRepo.existsById(anyInt())).thenReturn(true);
        when(userRepo.saveAndFlush(user)).thenReturn(user);
        userService.update(user);
        verify(userRepo, times(1)).saveAndFlush(any());
        verify(userRepo, times(1)).saveAndFlush(any());
    }

    @Test
    public void delete() throws Exception {
        User user = (User) ctx.getBean("user");
        userService.delete(user);
        verify(userRepo, times(1)).delete(any());
    }

    @Test
    public void deleteById() throws Exception {
        userService.deleteById(anyInt());
        verify(userRepo, times(1)).deleteById(any());
    }

    @Test
    public void getById() {
        int id = 1;
        User expected = (User) ctx.getBean("user");
        when(userRepo.findById(id)).thenReturn(Optional.of(expected));
        User actual = userService.getById(id);
        assertThat(actual, is(expected));
        verify(userRepo, times(1)).findById(any());
    }

    @Test
    public void getByName() {
        User expected = (User) ctx.getBean("user");
        when(userRepo.findOneByUsername(expected.getUsername())).thenReturn(expected);
        User actual = userService.getByName(expected.getUsername());
        assertThat(actual, is(expected));
        verify(userRepo, times(1)).findOneByUsername(any());
    }

    @Test
    public void getAll() {
        List<User> expectedUsers = new ArrayList<>();
        expectedUsers.add((User) ctx.getBean("user"));
        expectedUsers.add((User) ctx.getBean("user2"));
        when(userRepo.findAll()).thenReturn(expectedUsers);
        List<User> actualUsers = userService.getAll();
        assertThat(actualUsers.size(), is(expectedUsers.size()));
        verify(userRepo, times(1)).findAll();
    }

}