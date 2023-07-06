package com.vadimzhavoronkov.springboot.pp_3_1_2.web.controller;


import com.vadimzhavoronkov.springboot.pp_3_1_2.web.model.User;
import com.vadimzhavoronkov.springboot.pp_3_1_2.web.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String setPage() {
        return "redirect:/users";
    }
    @GetMapping(value = "/users")
    public String printAllUsers(ModelMap model) {
        model.addAttribute("users", userService.allUsers());
        return "users";
    }

    @RequestMapping(value = "/delete/{id}")
    private String deleteUser(@PathVariable(name = "id") String id){
        userService.delete(userService.getById(Integer.parseInt(id)));
        return "redirect:/users";
    }

    @GetMapping(value = "/edit/{id}")
    private String editUser(@PathVariable(name = "id") int id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping(value = "/edit")
    public String editUserPage(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-user";
        }
        userService.edit(user);
        return "redirect:/users";
    }

    @GetMapping("/addView")
    public String addUserPage(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "add-user";
        }
        userService.add(user);
        return "redirect:/users";
    }
}

