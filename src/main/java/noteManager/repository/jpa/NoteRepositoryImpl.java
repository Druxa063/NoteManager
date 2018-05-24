package noteManager.repository.jpa;

import noteManager.model.Note;
import noteManager.repository.NoteRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class NoteRepositoryImpl implements NoteRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public Note save(Note note) {
        if(note.isNew()) {
            em.persist(note);
            return note;
        } else {
            return em.merge(note);
        }
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        return em.createNamedQuery(Note.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public Note get(int id) {
        return em.find(Note.class, id);
    }

    @Override
    public List<Note> getAll() {
        return em.createNamedQuery(Note.ALL_SORTED, Note.class).getResultList();
    }
}
