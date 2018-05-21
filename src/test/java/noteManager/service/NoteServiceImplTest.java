package noteManager.service;

import noteManager.model.Note;
import noteManager.repository.NoteRepository;
import noteManager.repository.jpa.NoteRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/spring-db.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class NoteServiceImplTest {

    @Autowired
    private NoteRepository repository;

    @Test
    public void create() {
        Note newNote = new Note("", "description", LocalDateTime.now());
        Note get = repository.save(newNote);
        newNote.setId(get.getId());
        assertEquals(repository.get(100005).toString(), newNote.toString());
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void get() {
    }

    @Test
    public void getAll() {
        List<Note> list = repository.getAll();
        System.out.println("---------------------------------");
        System.out.println(list.size());
        System.out.println("------------------------------------");
    }
}