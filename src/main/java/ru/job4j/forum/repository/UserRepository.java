package ru.job4j.forum.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select distinct u from User u where u.username = ?1 and u.password = ?2")
    Optional<User> findUserByUsernameAndPassword(String username, String password);

    @Query("select distinct u from User u where u.username = ?1")
    Optional<User> findUserByName(String name);
}
