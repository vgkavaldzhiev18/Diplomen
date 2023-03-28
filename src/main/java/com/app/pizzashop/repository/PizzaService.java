package com.app.pizzashop.repository;

import com.app.pizzashop.entity.Pizza;

import java.util.List;

public interface PizzaService {
    public Pizza createPizza(String sizeId, String doughId,
                             List<String> toppingsIds,
                             List<String>saucesIds);
}
