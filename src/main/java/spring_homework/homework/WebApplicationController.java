package spring_homework.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String getOneUser(Model model, Authentication authentication) {

       model.addAttribute("user", userService.findByUsername(((UserDetails)authentication.getPrincipal()).getUsername()));
        return "user";
    }

    @GetMapping("/index")
    public String getAllUsersList(Model model){
        model.addAttribute("users", userService.findAll());
        return "index";
    }

}
