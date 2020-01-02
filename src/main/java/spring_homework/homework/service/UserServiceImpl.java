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

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean delete(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean add(User user){
        if (findByUsername(user.getUsername())!= null){
            return false;
        }
        user.setLogin_count(0);
        user.setLast_login(null);
        return userRepository.save(user) != null;
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByUsername(String username){
        return  userRepository.findByUsername(username);
    }

    @Override
    @ModelAttribute("users")
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void updateLoginData(String username){
        User user = findByUsername(username);
        if (user !=null){
            user.setLogin_count(user.getLogin_count()+1);
            user.setLast_login(Timestamp.valueOf(LocalDateTime.now()));

            save(user);

        }
    }




}
