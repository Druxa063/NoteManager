package noteManager.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(name = Note.DELETE, query = "DELETE FROM Note n WHERE n.id=:id"),
        @NamedQuery(name = Note.ALL_SORTED, query = "SELECT n FROM Note n ORDER BY n.dateTime DESC")
})
@Entity
@Table(name = "notes")
public class Note {

    public static final int START_SEQ = 100000;

    public static final String ALL_SORTED = "Note.getAll";
    public static final String DELETE = "Note.delete";

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "date_time")
    @NotNull
    private LocalDateTime dateTime;

    @Column(name = "made")
    @NotNull
    private boolean made;

    public Note(){}

    public Note(String title, String description, LocalDateTime dateTime) {
        this(null, title, description, dateTime, false);
    }

    public Note(Integer id, String title, String description, LocalDateTime dateTime, boolean made) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.made = made;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isMade() {
        return made;
    }

    public void setMade(boolean made) {
        this.made = made;
    }

    public boolean isNew() {
        return id == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", made=" + made +
                '}';
    }
}
