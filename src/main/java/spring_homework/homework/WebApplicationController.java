package spring_homework.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring_homework.homework.model.User;
import spring_homework.homework.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class WebApplicationController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String getOneUser(Model model, Authentication authentication) {

       model.addAttribute("user", userService.findByUsername(((UserDetails)authentication.getPrincipal()).getUsername()));
        return "user";
    }

    @GetMapping("/add")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "add";
    }

    @RequestMapping(value="/adduser",method=RequestMethod.POST)
    public String addNewUser(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "add";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.add(user);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String getAllUsersList(Model model){
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    @GetMapping("/findform")
    public String findForm(Model model){
        model.addAttribute("finduser", new User());
        return "find";
    }

    @RequestMapping(value= "/find", method = RequestMethod.POST)
    public String findUser(@ModelAttribute("finduser") User finduser, BindingResult result, ModelMap model ) {
        if (result.hasErrors()) {
            return "find";
        }
        Iterable<User> it = userService.findByExample(finduser);
        model.addAttribute("users", it);
        return "index";
    }

    @RequestMapping(value= {"/index/edit/{id}", "/user/edit/{id}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable("id") String id, ModelMap model ) {
        User user = userService.findById(id);
        user.setPassword("");
        model.put("edituser", user);
        return  "edit";
    }

    @RequestMapping(value="/update",method=RequestMethod.POST)
    public String saveUser(@ModelAttribute("edituser") User edituser, BindingResult result,
                           ModelMap model) {
        if (result.hasErrors()) {
            return "edit";
        }

        edituser.setPassword(passwordEncoder.encode(edituser.getPassword()));
        userService.save(edituser);
        return "redirect:/index";
    }

    @RequestMapping(value= "/index/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") String id, ModelMap model ) {
        userService.delete(id);
        return "redirect:/index";
    }
}
