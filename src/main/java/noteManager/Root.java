package noteManager;

import noteManager.controller.NoteController;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Root {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("spring/spring-app.xml")){
            NoteController controller = app.getBean(NoteController.class);
            controller.getAll().forEach(System.out::println);
        }
    }
}
