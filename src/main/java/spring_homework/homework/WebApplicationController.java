package spring_homework.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring_homework.homework.model.User;
import spring_homework.homework.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebApplicationController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@ModelAttribute String username){
        System.out.println(username);
        return "redirect:/index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
//
//    @GetMapping("/user")
//    public String userIndex() {
//        return "user/index";
//    }

    @GetMapping("/index")
    public String getUsersList(Model model){
        model.addAttribute("users", userService.findAll());
        return "index";
    }

}
