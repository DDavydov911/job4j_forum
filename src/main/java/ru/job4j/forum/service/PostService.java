package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostsMem;

import java.util.List;

@Service
public class PostService {

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
}