package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import java.security.Principal;
import java.util.Calendar;

@Controller
public class PostsController {

    private final PostService postService;

    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public String getPost(Model model, @RequestParam("id") int id,  Principal principal) {
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("user", principal.getName());
        return "post";
    }

    @RequestMapping(value = "/post/create", method = RequestMethod.GET)
    public String create(Model model, Principal principal) {
        model.addAttribute("user", principal.getName());
        return "create";
    }

    @RequestMapping(value = "/post/create", method = RequestMethod.POST)
    public String create(@ModelAttribute Post post) {
        post.setCreated(Calendar.getInstance());
        postService.create(post);
        return "redirect:/post?id=" + post.getId();
    }

    @GetMapping("/update")
    public String editPost(Model model, @RequestParam("id") int id, Principal principal) {
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("user", principal.getName());
        return "update";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute Post post) {
        postService.updatePost(post);
        return "redirect:/post?id=" + post.getId();
    }
}
