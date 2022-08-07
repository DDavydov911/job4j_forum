package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class PostsController {

    private final PostService postService;

    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public String getPost(Model model, @RequestParam("id") int id) {
        model.addAttribute("post", postService.findBiId(id));
        return "post";
    }

    @GetMapping("/update")
    public String editPost(Model model, @RequestParam("id") int id) {
        model.addAttribute("post", postService.findBiId(id));
        return "update";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute Post post) {
        postService.updatePost(post);
        return "redirect:/";
    }
}
