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


    @GetMapping("/list")
    public String findAll() {
        userService.findAll();
        return "/form";
    }

    @GetMapping(value = "/new")
    public String addUserForm(@ModelAttribute("user") User user, BindingResult bindingResult,
                              Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("user",userService.findAll());
        }

        return "/add";
    }

    @PostMapping
    public String create(@ModelAttribute("user")User user) {
        userService.save(user);

        return "redirect:/list";
    }


    @GetMapping(value = "/edit")
    public String edit(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("person", userService.read(id));

        return "/edit";
    }


    @PatchMapping(value = "/{id}")
    public String update(@ModelAttribute User user, Model model) {
        userService.update(user);
        return "redirect:/list";
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);

        return "redirect:/list";
    }
}
