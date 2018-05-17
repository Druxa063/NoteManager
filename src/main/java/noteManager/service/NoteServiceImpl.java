package noteManager.service;

import noteManager.modal.Note;
import noteManager.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository repository;

    @Override
    public Note create(Note note) {
        return repository.save(note);
    }

    @Override
    public Note update(Note note) {
        return repository.save(note);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Note get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Note> getAll() {
        return repository.getAll();
    }
}
