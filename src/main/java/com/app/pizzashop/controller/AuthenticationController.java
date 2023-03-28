package com.app.pizzashop.controller;

import com.app.pizzashop.repository.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    private ModelMapper mapper;
    private UserService service;

    @Autowired
    public AuthenticationController(ModelMapper mapper, UserService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping("/admin-login")
    private String getAdminLogin(){
        return "admin-login";
    }

    @GetMapping("/login")
    private String getLogin(){
        return "login";
    }

    @GetMapping("/loginError")
    private String loginError(Model model){
        model.addAttribute("loginError", true);
        return "login";
    }

}
