package com.app.pizzashop.service;

import com.app.pizzashop.entity.Sauce;
import com.app.pizzashop.repository.SauceRepository;
import com.app.pizzashop.repository.SauceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SauceServiceImpl implements SauceService {
    private SauceRepository repository;

    @Autowired
    public SauceServiceImpl(SauceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Sauce> findALlSauces() {
        return repository.findAll();
    }

    @Override
    public Sauce findById(String id) {

        return repository.findById(id).get();
    }
}
