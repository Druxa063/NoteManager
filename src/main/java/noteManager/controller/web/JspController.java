package noteManager.controller.web;

import noteManager.controller.NoteController;
import noteManager.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
public class JspController extends NoteController {

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("notes", super.getAll());
        return "notes";
    }

    @GetMapping("/update/{id}")
    public String get(@PathVariable("id") int id, Model model) {
        model.addAttribute("note", super.get(id));
        return "noteForm";
    }

    @PostMapping("/")
    public String save(Note note) {
//        Note note = new Note();
//        note.setTitle(request.getParameter("title"));
//        note.setDescription(request.getParameter("description"));
//        note.setDateTime(LocalDateTime.parse(request.getParameter("dateTime")));
//        note.setMade(Boolean.parseBoolean(request.getParameter("made")));
        if(note.isNew()) {
            super.create(note);
        } else {
            super.update(note);
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") int id) {
        super.delete(id);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Note note = new Note();
        note.setDateTime(LocalDateTime.now());
        model.addAttribute("note", note);
        return "noteForm";
    }

}
