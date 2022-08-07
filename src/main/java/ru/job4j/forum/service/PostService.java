package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;
import ru.job4j.forum.repository.PostsMem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public Post findBiId(int id) {
        return posts.findById(id).get();
    }

    public Optional<Post> updatePost(Post post) {
        return posts.update(post);
    }


    /**
    private final PostsMem posts;

    public PostService(PostsMem posts) {
        this.posts = posts;
    }

    public Post addPost(Post post) {
        return posts.addPost(post);
    }

    public List<Post> getAll() {
        return posts.getAll();
    }

    public Post findBiId(int id) {
        return posts.findById(id);
    }

    public void updatePost(Post post) {
        posts.updatePost(post);
    }
     */
}