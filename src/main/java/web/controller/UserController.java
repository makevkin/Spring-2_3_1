package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/") // показать всех пользователей
    public String showAllUsers(Model model) {
        List<User> listUser = userService.getAllUsers();
        model.addAttribute("users", listUser);
        //model.addAttribute("allUsers", userService.getAllUsers());
        return "showAll";
    }

    @GetMapping("/add") // форма для добавления нового пользователя
    public String addUserForm(@ModelAttribute("newUser") User user) {
        return "newUser";
    }

    @PostMapping("/add") // добавление нового пользователя
    public String addUser(@ModelAttribute("newUser") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/delete") // удаление пользователя по id
    public String deleteUser(@RequestParam("userId") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editUserForm(@RequestParam("id") int id, Model model) {
        User user = userService.getUserId(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PatchMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}


