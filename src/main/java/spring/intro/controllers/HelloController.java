package spring.intro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping(value = "/hello")
    public String sayHello() {
        return "Hello123";
    }

    @GetMapping(value = "/")
    public String init() {
        return "Hello123";
    }
}
