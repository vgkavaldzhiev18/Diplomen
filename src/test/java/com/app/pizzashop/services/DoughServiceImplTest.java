package com.app.pizzashop.services;

import com.app.pizzashop.entity.Dough;
import com.app.pizzashop.repository.DoughRepository;
import com.app.pizzashop.service.DoughServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DoughServiceImplTest {

    private DoughRepository repository;
    private DoughServiceImpl service;

    private Dough dough;

    @Before
    public void setUp() {
        repository = mock(DoughRepository.class);
        service = new DoughServiceImpl(repository);
        dough = new Dough("Thin", 3.50);
    }

    @Test
    public void testGetAllDoughs() {
        List<Dough> doughs = new ArrayList<>();
        doughs.add(dough);

        when(repository.findAll()).thenReturn(doughs);

        List<Dough> result = service.getAllDoughs();

        assertEquals(doughs, result);
    }

    @Test
    public void testFindById() {
        String id = "1234";

        when(repository.findById(id)).thenReturn(Optional.of(dough));

        Dough result = service.findById(id);

        assertEquals(dough, result);
    }
}
