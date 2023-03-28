package com.app.pizzashop.service;

import com.app.pizzashop.entity.*;
import com.app.pizzashop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService{

    private PizzaRepository repository;

    private ToppingService toppingService;

    private DoughService doughService;

    private SauceService sauceService;

    private SizeService sizeService;
    @Autowired
    public PizzaServiceImpl(PizzaRepository repository, ToppingService toppingService, DoughService doughService, SauceService sauceService, SizeService sizeService) {
        this.repository = repository;
        this.toppingService = toppingService;
        this.doughService = doughService;
        this.sauceService = sauceService;
        this.sizeService = sizeService;
    }


    public Pizza createPizza(String sizeId, String doughId,
                             List<String> toppingsIds,
                             List<String>saucesIds){
        double price = 0;
        Pizza pizza = new Pizza();
        Dough dough = doughService.findById(doughId);
        pizza.setDough(dough);

        Size size = sizeService.findById(sizeId);
        pizza.setSize(size);

        price+=dough.getPrice();
        price+=size.getPrice();

        List<Topping>toppings = new ArrayList<>();
        for (String toppingsId : toppingsIds) {
            Topping topping = toppingService.findById(toppingsId);
            price+=topping.getPrice();
            toppings.add(topping);
        }
        pizza.setToppings(toppings);
        List<Sauce>sauces = new ArrayList<>();

        for (String saucesId : saucesIds) {
            Sauce sauce = sauceService.findById(saucesId);
            sauces.add(sauce);
            price+=sauce.getPrice();
        }
        pizza.setSauce(sauces);
        pizza.setPrice(price);
        repository.save(pizza);
        return pizza;
    }


}
