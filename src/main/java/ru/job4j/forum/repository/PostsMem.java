package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostsMem {
    private final AtomicInteger id = new AtomicInteger(0);
    private final Map<Integer, Post> posts = new ConcurrentHashMap();

    public PostsMem() {
        Post p1 = Post.of("Post 1");
        p1.setId(id.incrementAndGet());
        p1.setDescription("some text1");
        p1.setCreated(Calendar.getInstance());
        System.out.println(p1.getCreated().getTime());
        posts.put(id.get(), p1);
        Post p2 = Post.of("Post 2");
        p2.setId(id.incrementAndGet());
        p2.setDescription("some text2");
        p2.setCreated(Calendar.getInstance());
        posts.put(id.get(), p2);
        Post p3 = Post.of("Post 3");
        p3.setId(id.incrementAndGet());
        p3.setDescription("some text3");
        p3.setCreated(Calendar.getInstance());
        posts.put(id.get(), p3);
    }

    public Post addPost(Post post) {
        post.setId(id.incrementAndGet());
        posts.put(post.getId(), post);
        return post;
    }

    public List<Post> getAll() {
        return new ArrayList<>(posts.values());
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public void updatePost(Post post) {
        posts.replace(post.getId(), post);
    }
}
