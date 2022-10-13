package app.service;

import app.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> getUserList();

    User getUser(int id);


    void updateUser(User user);

    void deleteUser(int id);
}
