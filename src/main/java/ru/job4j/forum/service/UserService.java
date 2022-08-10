package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository users;

    public UserService(UserRepository users) {
        this.users = users;
    }

    public User findUserByUsernameAndPassword(String email, String password) {
        return users.findUserByUsernameAndPassword(email, password).get();
    }

    public void save(User user) {
        System.out.println("Saving in Service" + user);
        users.save(user);
    }

    public Optional<User> findUserByName(String name) {
        return users.findUserByName(name);
    }
}
