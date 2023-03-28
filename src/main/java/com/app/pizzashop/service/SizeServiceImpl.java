package com.app.pizzashop.service;

import com.app.pizzashop.entity.Size;
import com.app.pizzashop.repository.SizeRepository;
import com.app.pizzashop.repository.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {
    private SizeRepository repository;

    @Autowired
    public SizeServiceImpl(SizeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Size> findAllSizes() {
        return this.repository.findAll();
    }

    @Override
    public Size findById(String id) {
        return repository.findById(id).get();
    }
}
