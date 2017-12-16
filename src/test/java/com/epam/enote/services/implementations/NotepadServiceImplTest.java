package com.epam.enote.services.implementations;

import com.epam.enote.config.AppConfig;
import com.epam.enote.entities.Notepad;
import com.epam.enote.entities.User;
import com.epam.enote.repos.NotepadRepo;
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
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class NotepadServiceImplTest {

    @Mock
    NotepadRepo notepadRepo;
    @Mock
    UserRepo userRepo;
    @Mock
    User user;


    private ConfigurableApplicationContext ctx;
    private NotepadServiceImpl notepadService;


    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("db/testData.xml");
        notepadService = new NotepadServiceImpl(notepadRepo, userRepo);
    }

    @Test
    public void create() {
        Notepad notepad = (Notepad) ctx.getBean("notepad");
        notepadService.create(notepad);
        verify(userRepo, times(1)).save(any());
    }

    @Test
    public void delete() {
        Notepad notepad = (Notepad) ctx.getBean("notepad");
        notepadService.delete(notepad);
        verify(notepadRepo, times(1)).delete(any());
    }

    @Test
    public void update() {
        Notepad notepad = (Notepad) ctx.getBean("notepad");
        notepadService.update(notepad);
        verify(notepadRepo, times(1)).saveAndFlush(any());
    }

    @Test
    public void getAllByUser() {
        notepadService.getAllByUser(user);
        verify(user, times(1)).getNotepads();
    }

    @Test
    public void findByName() {
        Notepad notepad = (Notepad) ctx.getBean("notepad");
        notepadService.findByName(notepad.getName());
        verify(notepadRepo, times(1)).findByName(any());
    }
}