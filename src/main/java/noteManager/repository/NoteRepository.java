package noteManager.repository;

import noteManager.modal.Note;

import java.util.List;

public interface NoteRepository {

    Note save(Note note);

    boolean delete(int id);

    Note get(int id);

    List<Note> getAll();

}
