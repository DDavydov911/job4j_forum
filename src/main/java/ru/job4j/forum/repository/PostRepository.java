package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

   Post save(Post post);
}
