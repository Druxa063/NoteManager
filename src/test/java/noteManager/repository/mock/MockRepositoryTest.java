package noteManager.repository.mock;

import noteManager.modal.Note;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class MockRepositoryTest {

    private static MockRepository repository;

    @BeforeClass
    public static void set(){
        ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        repository = app.getBean(MockRepository.class);
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