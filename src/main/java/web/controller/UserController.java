package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUsers( ModelMap model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @PostMapping("/add")
    public String addUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add";
    }

    @PostMapping("/input")
    public String inputUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("editable_user", userService.getUser(id));
        return "edit";
    }

    @GetMapping("/{id}")
    public String edit(@ModelAttribute("editable_user") User user, @RequestParam("id") Long id) {
        userService.editUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}