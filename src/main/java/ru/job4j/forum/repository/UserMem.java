package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.model.User;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserMem {

    private final AtomicInteger id = new AtomicInteger(0);
    private final Map<Integer, User> users = new ConcurrentHashMap();

    public UserMem() {
        Authority auth = new Authority();
        users.put(1, new User(1, "123", "123", auth, true));
    }

    public Optional<User> findUserByEmailAndPassword(String email, String pass) {
        return users.values()
                .stream()
                .filter(
                        user -> email.equals(user.getUsername()) && pass.equals(user.getPassword())
                )
                .findFirst();
    }

    public Optional<User> findUserByName(String name) {
        return users.values()
                .stream()
                .filter(user -> name.equals(user.getUsername()))
                .findFirst();
    }

    public void save(User user) {
        user.setId(id.incrementAndGet());
        users.put(id.get(), user);
    }
}
