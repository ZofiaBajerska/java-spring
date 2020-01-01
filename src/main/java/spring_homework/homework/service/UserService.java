package spring_homework.homework.service;

import spring_homework.homework.model.User;

import java.util.List;

public interface UserService {

    User save(User task);

    Boolean delete(String id);

    User update(User task);

    User findById(String id);

    List<User> findAll();

}
