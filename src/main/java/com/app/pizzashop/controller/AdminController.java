package com.app.pizzashop.controller;

import com.app.pizzashop.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService service;

    @Autowired
    public AdminController(UserService service) {
        this.service = service;
    }

    @GetMapping("/confirmUsers")
    public String confirmUsers(Model model){
        model.addAttribute("users", service.findAllIncompleteUsers());
        return "confirm-users";
    }
    @GetMapping("/confirmUser/{id}")
    public String confirmUsers(@PathVariable  String id){
        service.confirmUser(id);
        return "redirect:/admin/confirmUsers";
    }
}
