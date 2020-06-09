package spring.intro.controllers;

import java.util.List;
import java.util.stream.Collectors;
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
        return new UserResponseDto(userService.get(id));
    }

    @GetMapping("/")
    public List<UserResponseDto> getAll() {
        return userService
                .listUsers()
                .stream()
                .map(user -> new UserResponseDto(user))
                        .collect(Collectors.toList());
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
