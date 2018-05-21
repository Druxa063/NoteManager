package noteManager.repository;

import noteManager.model.Note;
import noteManager.repository.mock.MockRepository;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

public class MockRepositoryTest {
    private static  ConfigurableApplicationContext app;
    private static MockRepository repository;

    @BeforeClass
    public static void set(){
        app = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring-mock.xml");
        repository = app.getBean(MockRepository.class);
    }

    @AfterClass
    public static void destroy() {
        app.close();
    }


    @Test
    public void saveAndGet() {
        Note newNote = new Note("кино", "кино", LocalDateTime.now());
        repository.save(newNote);
        Assert.assertEquals(repository.get(4).toString(), newNote.toString());
        repository.delete(4);
        Assert.assertEquals(repository.getAll().size(), 4);
    }

}