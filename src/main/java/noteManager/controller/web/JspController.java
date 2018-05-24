package noteManager.controller.web;

import noteManager.controller.NoteController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspController extends NoteController {

    @GetMapping("/notes")
    public String getAll(Model model) {
        model.addAttribute("notes", super.getAll());
        return "notes";
    }

}
