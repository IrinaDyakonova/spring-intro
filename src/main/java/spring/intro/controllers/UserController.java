package spring.intro.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.intro.config.AppConfig;
import spring.intro.dto.UserResponseDto;
import spring.intro.model.User;
import spring.intro.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);
    UserService userService = context.getBean(UserService.class);

    @GetMapping("/get/{id}")
    public UserResponseDto get(@PathVariable Long id) {
        UserResponseDto user = null;
        user = new UserResponseDto(userService
                .listUsers()
                .stream()
                .filter(user1 -> user1.getId().equals(id))
                .findFirst()
                .get());
        return user;
    }

    @GetMapping("/")
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> usersList = new ArrayList<>();
        userService
                .listUsers()
                .stream()
                .forEach(user -> usersList.add(new UserResponseDto(user)));
        return usersList;
    }

    @GetMapping("/inject")
    public String injectUsersFromDB() {
        userService.add(new User("Pavel", "pavelfromua@gmail.com", "1234"));
        userService.add(new User("Helen", "helenfromua@gmail.com", "1111"));
        userService.add(new User("Nicole", "nicolefromua@gmail.com", "2222"));
        userService.add(new User("Victor", "victorfromua@gmail.com", "3333"));
        return "Inject four users from DB finished";
    }
}
