package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository users;

    public UserService(UserRepository users) {
        this.users = users;
    }

    public User findUserByEmailAndPassword(String email, String password) {
        return users.findUserByEmailAndPassword(email, password).get();
    }

    public void save(User user) {
        System.out.println("Saving in Service" + user);
        users.save(user);
    }

    public User findUserByName(String name) {
        return users.findUserByName(name).get();
    }
}
