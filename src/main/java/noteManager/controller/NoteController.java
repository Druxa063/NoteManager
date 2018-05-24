package noteManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import noteManager.model.Note;
import noteManager.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class NoteController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private NoteService service;

    public Note Create(Note note) {
        log.debug("create {}", note);
        return service.create(note);
    }

    public Note update(Note note) {
        log.debug("update {}", note);
        return service.update(note);
    }

    public void delete(int id) {
        log.debug("delete {}", id);
        service.delete(id);
    }

    public Note get(int id) {
        log.debug("get {}", id);
        return service.get(id);
    }

    public List<Note> getAll() {
        log.debug("getAll");
        return service.getAll();
    }
}
