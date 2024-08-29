package be.bstorm.tf_java2024_demospringsecuritymvc.pl.controllers.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("login")
    public String login() {
        return "auth/login";
    }
}
