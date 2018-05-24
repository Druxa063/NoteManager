package noteManager.service;

import noteManager.model.Note;
import noteManager.repository.NoteRepository;
import noteManager.repository.jpa.NoteRepositoryImpl;
import org.assertj.core.api.Assertions;
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
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class NoteServiceImplTest {

    @Autowired
    private NoteRepository repository;

    @Test
    public void create() {
        Note newNote = new Note("", "description", LocalDateTime.now());
        Note get = repository.save(newNote);
        newNote.setId(get.getId());
        Assertions.assertThat(repository.get(get.getId())).isEqualTo(newNote);
    }

    @Test
    public void update() {
        Note get = repository.get(100001);
        get.setDescription("newDescription");
        get.setMade(true);
        Note getUpdate = repository.save(get);
        Assertions.assertThat(get).isEqualTo(getUpdate);
    }

    @Test
    public void delete() {
        List<Note> getList = repository.getAll();
        repository.delete(100001);
        Assertions.assertThat(getList).isNotEqualTo(repository.getAll());
    }

    @Test
    public void get() {
        Note get = repository.get(100000);
        Note newNote = new Note(100000, "кино", "сходить в кино на мстелей 4", LocalDateTime.of(2018, 05, 04, 10, 00), false);
        Assertions.assertThat(get).isEqualTo(newNote);
    }

    @Test
    public void getAll() {
        List<Note> list = repository.getAll();
        assertEquals(list.size(), 5);
    }
}