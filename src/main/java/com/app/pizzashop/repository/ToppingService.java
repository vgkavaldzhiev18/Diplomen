package com.app.pizzashop.repository;

import com.app.pizzashop.entity.Topping;
import java.util.*;
public interface ToppingService {

    List<Topping>findAllToppings();
    Topping findById(String id);
}
