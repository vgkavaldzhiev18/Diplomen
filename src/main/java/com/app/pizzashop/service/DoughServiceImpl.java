package com.app.pizzashop.service;

import com.app.pizzashop.entity.Dough;
import com.app.pizzashop.repository.DoughRepository;
import com.app.pizzashop.repository.DoughService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoughServiceImpl implements DoughService {
    private DoughRepository repository;


    @Autowired
    public DoughServiceImpl(DoughRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Dough> getAllDoughs() {
        return repository.findAll();
    }

    @Override
    public Dough findById(String id) {
        return repository.findById(id).get();
    }
}
