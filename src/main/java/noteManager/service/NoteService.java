package noteManager.service;

import noteManager.model.Note;

import java.util.List;

public interface NoteService {

    Note create(Note note);

    Note update(Note note);

    void delete(int id);

    Note get(int id);

    List<Note> getAll();
}
