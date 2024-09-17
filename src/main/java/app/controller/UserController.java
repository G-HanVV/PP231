package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import app.model.User;
import app.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String showUsers(ModelMap model){
//        System.out.println(" --- startUser");
        List<User> users = userService.getUserList();
        model.addAttribute("users", users);
        return "/index";
    }

    @GetMapping (value = "/form")
    public String newUserForm(ModelMap model){
//        System.out.println(" --- newUser");
        model.addAttribute("user", new User());
        return "/form";
    }

    @PostMapping("/user")
    public String createUser(@ModelAttribute("user") User user){
//        System.out.println(" --- create");
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(ModelMap model, @PathVariable("id") int id){
//        System.out.println(" --- editUser");
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id){
//        System.out.println(" --- updateUser");
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id){
//        System.out.println(" --- deleteUser");
        userService.deleteUser(id);
        return "redirect:/";
    }
}
