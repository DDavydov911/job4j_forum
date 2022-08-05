package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }


    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        model.addAttribute("user", userService.findUserByEmailAndPassword(
                username, password)
        );
        return "redirect:/index";
    }

    @GetMapping("/reg")
    public String regForm() {
        return "reg";
    }

    @PostMapping("/reg")
    public String registration(@ModelAttribute User user) {
        System.out.println(user);
        if (userService.findUserByName(user.getUsername()).isEmpty()) {
            userService.save(user);
        }
        return "redirect:/login";
    }

}
