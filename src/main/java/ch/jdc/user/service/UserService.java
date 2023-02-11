package ch.jdc.user.service;

import ch.jdc.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void create(User user);

    void update(String id, User user);

    void delete (String id);
}
