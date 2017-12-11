package db;

import com.epam.enote.config.AppConfig;
import com.epam.enote.entities.Note;
import com.epam.enote.entities.Tag;
import com.epam.enote.repos.NoteRepo;
import com.epam.enote.repos.TagRepo;
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

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TagRepoTest {

    public static final int DEFAULT_ID = 1;
    public static final int NOT_EXISTENT_ID = 99;
    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private TagRepo tagRepo;

    ConfigurableApplicationContext configurableApplicationContext;

    @Before
    public void setUp() {
        configurableApplicationContext = new ClassPathXmlApplicationContext("db/testData.xml");
        Tag note = (Tag) configurableApplicationContext.getBean("tag");
        tagRepo.save(note);
    }

    @Test
    public void testTagRepo() {
        assertNotNull("appContext should not be null", appContext);
        assertNotNull("userRepo should not be null", tagRepo);
    }

    @Test
    public void testFindAll() throws SQLException {
        tagRepo.save((Tag) configurableApplicationContext.getBean("tag2"));
        List<Tag> users = tagRepo.findAll();
        assertTrue(users.size() == 2);
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoFindById() {
        tagRepo.findById(NOT_EXISTENT_ID).get();
    }

    @Test
    public void testFindById() {
        assertNotNull(tagRepo.findById(DEFAULT_ID).get());
    }


    @Test
    public void testUpdate() {
        Tag tag = tagRepo.findOneByName("fun");
        tag.setName("meme");
        tagRepo.saveAndFlush(tag);
        Tag tagAltered = tagRepo.findOneByName("meme");
        assertEquals("meme", tagAltered.getName());
    }

    @Test
    public void testDelete() {
        Tag tag = tagRepo.findAll().get(0);
        assertNotNull(tagRepo.findById(tag.getId()));
        tagRepo.delete(tag);
        assertEquals(tagRepo.findById(tag.getId()), Optional.empty());
    }
}
