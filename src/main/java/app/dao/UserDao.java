package app.dao;

import app.model.User;

import java.util.List;


public interface UserDao {

    void add(User user);


    List<User> getUserList();

    User getUser(int id);

    void updateUser(User user);

    void deleteUser(int id);
}
