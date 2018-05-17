package noteManager.modal;

import java.time.LocalDateTime;
import java.util.Objects;

public class Note {
    private Integer id;
    private String title;
    private String description;
    private LocalDateTime dateTime;
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
