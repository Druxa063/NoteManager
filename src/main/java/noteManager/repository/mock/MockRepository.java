package noteManager.repository.mock;

import noteManager.modal.Note;
import noteManager.repository.NoteRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MockRepository implements NoteRepository {
    private static Map<Integer, Note> notes = new HashMap<>();
    private static AtomicInteger incr = new AtomicInteger();

    static {
        notes.put(incr.getAndIncrement(), new Note(incr.get(), "Бег", "Пробежка в парке", LocalDateTime.now(), false));
        notes.put(incr.getAndIncrement(), new Note(incr.get(), "Ресторан", "Пойти на свидание в ресторан", LocalDateTime.now(), false));
        notes.put(incr.getAndIncrement(), new Note(incr.get(), "Счета", "Отралить счета", LocalDateTime.now(), false));
        notes.put(incr.getAndIncrement(), new Note(incr.get(), "Фильм", "Посмотреть дедпул2", LocalDateTime.now(), false));
    }

    @Override
    public Note save(Note note) {
        if(note.isNew()) {
            int i = incr.getAndIncrement();
            note.setId(i);
            return notes.put(i, note);
        } else {
            return notes.put(note.getId(), note);
        }
    }

    @Override
    public boolean delete(int id) {
        return notes.remove(get(id)) != null;
    }

    @Override
    public Note get(int id) {
        return notes.get(id);
    }

    @Override
    public List<Note> getAll() {
        return new ArrayList<>(notes.values());
    }
}
