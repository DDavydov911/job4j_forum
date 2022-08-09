package ru.job4j.forum.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    private final UserService userService;
    private final PasswordEncoder encoder;

    public UserController(UserService userService, PasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessge = null;
        if (error != null) {
            errorMessge = "Username or Password is incorrect !!";
        }
        if (logout != null) {
            errorMessge = "You have been successfully logged out !!";
        }
        model.addAttribute("errorMessge", errorMessge);
        return "login";
    }

//    @PostMapping("/login")
//    public String login(@RequestParam String username,
//    @RequestParam String password, Model model) {
//        model.addAttribute("user", userService.findUserByEmailAndPassword(
//                username, password)
//        );
//        return "redirect:/index";
//    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout=true";
    }

    @GetMapping("/reg")
    public String regForm() {
        return "reg";
    }

    @PostMapping("/reg")
    public String registration(@ModelAttribute User user, Model model) {
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user);
            userService.save(user);
            return "redirect:/login";
//        if (userService.findUserByName(user.getUsername()).isEmpty()) {
//        }
//        model.addAttribute("errorMessage", "Username already exists");
//        return "reg";
    }

//    @PostMapping("/reg2")
//    public String regSave(@ModelAttribute User user, Model model) {
//        user.setEnabled(true);
//        user.setPassword(encoder.encode(user.getPassword()));
//        user.setAuthority(authorities.findByAuthority("ROLE_USER"));
//        if (users.findByName(user.getUsername()).isEmpty()) {
//            users.save(user);
//            return "redirect:/login";
//        }
//        model.addAttribute("errorMessage", "Username already exists");
//        return "reg";
//    }
}
