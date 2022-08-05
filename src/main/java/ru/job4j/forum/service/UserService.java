package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.UserMem;

import java.util.Optional;

@Service
public class UserService {

    private final UserMem users;

    public UserService(UserMem users) {
        this.users = users;
    }

    public Optional<User> findUserByEmailAndPassword(String email, String password) {
        return users.findUserByEmailAndPswd(email, password);
    }

    public void save(User user) {
        users.save(user);
    }

    public Optional<User> findUserByName(String name) {
        return users.findUserByName(name);
    }
}
