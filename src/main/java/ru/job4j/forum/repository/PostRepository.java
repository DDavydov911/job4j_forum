package ru.job4j.forum.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

   @Transactional
   @Modifying
   @Query("update Post p set p.name = ?1, p.description = ?2 where p.id = ?3")
   void updatePost(String name, String description, int id);

   default Optional<Post> update(Post post) {
      updatePost(post.getName(), post.getDescription(), post.getId());
      return findById(post.getId());
   }
}
