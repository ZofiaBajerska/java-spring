package spring_homework.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring_homework.homework.model.User;
import spring_homework.homework.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User task) {
        return userRepository.save(task);
    }

    @Override
    public Boolean delete(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User update(User task) {
        return userRepository.save(task);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    @ModelAttribute("users")
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }




}
