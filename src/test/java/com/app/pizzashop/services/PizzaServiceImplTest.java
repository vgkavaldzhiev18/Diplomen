package com.app.pizzashop.services;

import com.app.pizzashop.entity.*;
import com.app.pizzashop.repository.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PizzaServiceImplTest {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private ToppingService toppingService;

    @Autowired
    private DoughService doughService;

    @Autowired
    private SauceService sauceService;

    @Autowired
    private SizeService sizeService;

    @Autowired
    private PizzaService pizzaService;

    @BeforeEach
    public void setUp() {
        pizzaRepository.deleteAll();
    }

    @Test
    public void testCreatePizza() {
        // Create a pizza with size, dough, toppings, and sauces
        String sizeId = "1";
        String doughId = "1";
        List<String> toppingsIds = new ArrayList<>();
        toppingsIds.add("1");
        toppingsIds.add("2");
        List<String> saucesIds = new ArrayList<>();
        saucesIds.add("1");
        saucesIds.add("2");

        Pizza pizza = pizzaService.createPizza(sizeId, doughId, toppingsIds, saucesIds);

        // Verify that the pizza was saved in the repository
        assertNotNull(pizza.getId());
        assertEquals(pizza, pizzaRepository.findById(pizza.getId()).get());

        // Verify that the pizza has the correct size, dough, toppings, and sauces
        assertEquals(sizeId, pizza.getSize().getId());
        assertEquals(doughId, pizza.getDough().getId());
        assertEquals(2, pizza.getToppings().size());
        assertEquals(2, pizza.getSauce().size());

        // Verify that the pizza's price is calculated correctly
        double expectedPrice = pizza.getDough().getPrice() + pizza.getSize().getPrice();
        for (Topping topping : pizza.getToppings()) {
            expectedPrice += topping.getPrice();
        }
        for (Sauce sauce : pizza.getSauce()) {
            expectedPrice += sauce.getPrice();
        }
        assertEquals(expectedPrice, pizza.getPrice());
    }
}
