package com.app.pizzashop.services;

import com.app.pizzashop.entity.Size;
import com.app.pizzashop.repository.SizeRepository;
import com.app.pizzashop.service.SizeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class SizeServiceImplTest {

    private SizeRepository repository;
    private SizeServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new SizeServiceImpl(repository);
    }

    @Test
    void testFindAllSizes() {
        List<Size> sizes = service.findAllSizes();
        Assertions.assertEquals(2, sizes.size());
    }

    @Test
    void testFindById() {
        Optional<Size> optionalSize = repository.findById("1");
        Assertions.assertTrue(optionalSize.isPresent());

        Size size = service.findById("1");
        Assertions.assertEquals(optionalSize.get(), size);
    }

}
