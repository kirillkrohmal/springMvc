package ru.demo.springmvcpack.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.demo.springmvcpack.model.User;
import ru.demo.springmvcpack.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

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

    @PutMapping(value = "list/{id}/edit")
    public String update(@ModelAttribute User user, Model model) {

        userService.update(user);
        return "/form";
    }

    @DeleteMapping(value = "list/{id}")
    public String delete(@PathVariable("id") int id, Model model) {

        User user = userService.delete(id);

        if(null == user) {
            throw new NullPointerException();
        }
        model.addAttribute(userService.delete(id));

        return "redirect:/list";
    }

}
