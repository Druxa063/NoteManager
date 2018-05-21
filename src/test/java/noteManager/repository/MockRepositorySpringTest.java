package noteManager.repository;

import noteManager.model.Note;
import noteManager.repository.mock.MockRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringRunner.class)
public class MockRepositorySpringTest {

    @Autowired
    private MockRepository repository;

    @Test
    public void saveAndGet() {
        Note newNote = new Note("кино", "кино", LocalDateTime.now());
        repository.save(newNote);
        Assert.assertEquals(repository.get(4).toString(), newNote.toString());
        repository.delete(4);
        Assert.assertEquals(repository.getAll().size(), 4);
    }
}
