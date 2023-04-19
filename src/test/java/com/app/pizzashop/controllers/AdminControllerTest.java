package com.app.pizzashop.controllers;

import com.app.pizzashop.controller.AdminController;
import com.app.pizzashop.repository.UserService;
import com.app.pizzashop.entity.UserChange;
import com.app.pizzashop.entity.STATUS;
import com.app.pizzashop.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminControllerTest {

    private UserService service;
    private AdminController controller;

    @BeforeEach
    public void setUp() {
        controller = new AdminController(service);
    }

    @Test
    public void testConfirmUsers() {
        ModelMap model = new ModelMap();
        String view = controller.confirmUsers((Model) model);

        assertEquals("confirm-users", view);
        assertEquals(2, ((List<UserChange>) model.get("users")).size());
    }
}
