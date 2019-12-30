//package spring_homework.homework.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import spring_homework.homework.UserRegistrationDto;
//import spring_homework.homework.model.User;
//
//import spring_homework.homework.repository.UserRepository;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//
//    @Autowired
//    private UserRepository userRepository;
//
////    @Autowired
////    private BCryptPasswordEncoder passwordEncoder;
//
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    public User save(UserRegistrationDto registration) {
//        User user = new User();
//        user.setId(registration.getUsername()+"123");
//        user.setUsername(registration.getUsername());
//       // user.setPassword(passwordEncoder.encode(registration.getPassword()));
//        user.setIs_admin(false);
//        user.setLogin_count(0);
//        user.setLast_login(null);
//        return userRepository.save(user);
//    }

//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return null;
//    }
//}


