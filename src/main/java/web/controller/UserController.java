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
    public String ShowAddUser (Model model) {
        model.addAttribute("user", new User());
        return "addUser "; // Удалите лишний пробел
    }

    @PostMapping("/add")
    public String AddUser (@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addUser "; // Обработка ошибок валидации
        }
        userService.addUser (user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String ShowEditUser (@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUser (id));
        return "editUser "; // Удалите лишний пробел
    }

    @PostMapping("/edit/{id}")
    public String EditUser (@PathVariable int id, @Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editUser "; // Обработка ошибок валидации
        }
        userService.editUser (id, user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String DeleteUser (@PathVariable int id) { // Используйте @PathVariable вместо @RequestParam
        userService.deleteUser (id);
        return "redirect:/users";
    }
}
