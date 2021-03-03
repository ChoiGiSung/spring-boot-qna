package com.codessquad.qna.repository;

import com.codessquad.qna.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public String save(User user) {
        users.add(user);
        return user.getUserId();
    }

    public List<User> findAll() {
        return Collections.unmodifiableList(users);
    }

    public User findUserById(String userId) {
        return users.stream()
                .filter(user -> userId.equals(userId))
                .findAny()
                .orElse(null);
    }
}
