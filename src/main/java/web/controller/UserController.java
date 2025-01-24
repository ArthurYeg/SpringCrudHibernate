package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping("/add")
    public String showAddUser (Model model) {
        model.addAttribute("user", new User());
        return "addUser ";
    }

    @PostMapping("/add")
    public String addUser (@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addUser ";
        }
        userService.addUser (user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditUser (@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUser (id));
        return "editUser ";
    }


    @PostMapping("/edit/{id}")
    public String editUser (@PathVariable int id, @Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editUser ";
        }
        userService.editUser (id, user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser (@PathVariable int id) {
        userService.deleteUser (id);
        return "redirect:/users";
    }
}