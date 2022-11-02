package ru.demo.springmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.demo.springmvc.model.User;
import ru.demo.springmvc.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/list")
    public String findAll() {
        userService.findAll();
        return "/form";
    }

    @PostMapping(value = "/new")
    public String addUserForm(@ModelAttribute("user") User user, BindingResult bindingResult,
                              Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("user",userService.findAll());
        }

        userService.save(user);

        return "/form";
    }

    @PutMapping(value = "{id}/edit")
    public String update(@ModelAttribute User user, Model model) {

        userService.update(user);
        return "/form";
    }

    @DeleteMapping(value = "/delete")
    public String delete(int id, Model model) {

        User user = userService.delete(id);


        if(null == user) {
            throw new NullPointerException();
        }
        model.addAttribute(userService.delete(id));

        return "redirect:/list";
    }

}
