package com.app.pizzashop.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.app.pizzashop.binding.ProfileEdit;
import com.app.pizzashop.controller.ProfileController;
import com.app.pizzashop.entity.AppUser;
import com.app.pizzashop.repository.UserService;

import com.app.pizzashop.service.UserServiceImpl;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

class ProfileControllerTest {

    private ProfileController controller;
    private UserService service;
    private Validator validator;
    private Model model;
    private RedirectAttributes redirectAttributes;

    @Test
    void testGetProfile() {
        // given
        String id = "1";
        AppUser user = new AppUser();
        user.setAuthIdentifier(id);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setPassword("password");
        user.setUsername("johndoe");
        ProfileEdit expected = new ProfileEdit(user.getAuthIdentifier(), user.getFirstName(), user.getLastName());
        String result = controller.getProfile(id, model);
        ProfileEdit actual = (ProfileEdit) model.getAttribute("user");
        assertEquals("profile.html", result);
        assertEquals(expected, actual);
    }



}
