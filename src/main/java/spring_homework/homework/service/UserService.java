package spring_homework.homework.service;

import spring_homework.homework.model.User;

import java.util.List;

public interface UserService {


    User save(User task);

    Boolean delete(String id);

    User findById(String id);

    User findByUsername(String username);

    List<User> findAll();

    void updateLoginData(String username);
}
