package noteManager;

import noteManager.controller.NoteController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Root {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        NoteController controller = app.getBean(NoteController.class);
        controller.getAll().forEach(System.out::println);
    }
}
