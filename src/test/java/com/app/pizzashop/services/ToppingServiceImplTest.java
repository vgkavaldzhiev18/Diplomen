package com.app.pizzashop.services;

import com.app.pizzashop.entity.Topping;
import com.app.pizzashop.repository.ToppingRepository;
import com.app.pizzashop.repository.ToppingService;
import com.app.pizzashop.service.ToppingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ToppingServiceImplTest {

    private ToppingRepository repository;
    private ToppingService service;

    @Test
    void testFindAllToppings() {
        // Add some fake toppings to the repository
        Topping topping1 = new Topping("Pepperoni", 2.0);
        Topping topping2 = new Topping("Mushrooms", 1.5);
        Topping topping3 = new Topping("Green Peppers", 1.0);
        repository.save(topping1);
        repository.save(topping2);
        repository.save(topping3);

        // Test that the service can retrieve all toppings from the repository
        List<Topping> toppings = service.findAllToppings();
        assertNotNull(toppings);
        assertEquals(3, toppings.size());
        assertEquals(topping1, toppings.get(0));
        assertEquals(topping2, toppings.get(1));
        assertEquals(topping3, toppings.get(2));
    }

    @Test
    void testFindById() {
        // Add a fake topping to the repository
        Topping topping = new Topping("Pepperoni", 2.0);
        repository.save(topping);

        // Test that the service can retrieve the topping by its ID
        Topping foundTopping = service.findById(topping.getId());
        assertNotNull(foundTopping);
        assertEquals(topping, foundTopping);
    }
}
