package be.bstorm.tf_java2024_demospringsecuritymvc.pl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String index() {
        return "admin/dashboard";
    }
}
