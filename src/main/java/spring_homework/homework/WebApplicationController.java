package spring_homework.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

//    @PostMapping("/login")
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ResponseBody
//    public String login(@ModelAttribute String username){
//        System.out.println(username);
//        return "index";
//    }
    @GetMapping("/")
    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken))
            return "index";

        // if it is not authenticated, then go to the index...
        // other things ...
        return "login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String getOneUser(Model model) {
//        model.addAttribute("user", userService.findUser());
        return "user";
    }

//    @GetMapping(value = {"/", "/index"})
    @GetMapping("/index")
    public String getAllUsersList(Model model){
        model.addAttribute("users", userService.findAll());
        return "index";
    }

}
