package com.app.pizzashop.controller;

import com.app.pizzashop.binding.ProfileEdit;
import com.app.pizzashop.entity.AppUser;
import com.app.pizzashop.repository.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private UserService service;

    @Autowired
    public ProfileController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    private String getProfile(@PathVariable String id, Model model) {
        if(!model.containsAttribute("user")){
            AppUser byAuthId = service.findByAuthId(id);
            model.addAttribute("user", new ProfileEdit(byAuthId.getAuthIdentifier(), byAuthId.getFirstName(),
                    byAuthId.getLastName()));
        }
        return "profile.html";
    }
    @PostMapping("/{id}")
    private String postProfile( @ModelAttribute @Valid ProfileEdit profileEdit,
                               BindingResult result, RedirectAttributes attributes) {
        String id = profileEdit.getId();
        if(result.hasErrors()){
            attributes.addFlashAttribute("user",profileEdit);
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
            return "redirect:/profile/" + id;
        }else{
            service.saveEditRequest(id,profileEdit);
        }
        return "redirect:/";
    }
}
