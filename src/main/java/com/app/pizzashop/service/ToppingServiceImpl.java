package com.app.pizzashop.service;

import com.app.pizzashop.entity.Topping;
import com.app.pizzashop.repository.ToppingRepository;
import com.app.pizzashop.repository.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToppingServiceImpl implements ToppingService {
    private ToppingRepository repository;

    @Autowired
    public ToppingServiceImpl(ToppingRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Topping> findAllToppings() {
        return repository.findAll();
    }

    @Override
    public Topping findById(String id) {
        return this.repository.findById(id).get();
    }
}
