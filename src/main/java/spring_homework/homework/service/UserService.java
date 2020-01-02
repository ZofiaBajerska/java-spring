package spring_homework.homework.service;

import spring_homework.homework.model.User;

import java.util.List;

public interface UserService {


    User save(User user);

    boolean add(User user);

    boolean delete(String id);

    User findById(String id);

    User findByUsername(String username);

    List<User> findAll();

    public Iterable<User> findByExample(User user);

    void updateLoginData(String username);
}
