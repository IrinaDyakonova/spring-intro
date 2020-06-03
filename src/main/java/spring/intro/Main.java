package spring.intro;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.intro.config.AppConfig;
import spring.intro.model.User;
import spring.intro.service.UserService;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Pavel", "pavelfromua@gmail.com", "1234"));
        userService.add(new User("Helen", "helenfromua@gmail.com", "1111"));
        userService.add(new User("Nicole", "nicolefromua@gmail.com", "2222"));
        userService.add(new User("Victor", "victorfromua@gmail.com", "3333"));

        List<User> userList = userService.listUsers();
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }
}
