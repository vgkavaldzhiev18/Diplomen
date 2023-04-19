package com.app.pizzashop.services;

import com.app.pizzashop.entity.Sauce;
import com.app.pizzashop.repository.SauceRepository;
import com.app.pizzashop.service.SauceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SauceServiceImplTest {
    private SauceRepository repository;
    private SauceServiceImpl service;

    @BeforeEach
    public void setUp() {
        repository = mock(SauceRepository.class);
        service = new SauceServiceImpl(repository);
    }

    @Test
    public void testFindAllSauces() {
        // Arrange
        List<Sauce> expectedSauces = new ArrayList<>();
        expectedSauces.add(new Sauce("Tomato", 1.00));
        expectedSauces.add(new Sauce("BBQ", 1.50));
        when(repository.findAll()).thenReturn(expectedSauces);

        // Act
        List<Sauce> actualSauces = service.findALlSauces();

        // Assert
        assertEquals(expectedSauces, actualSauces);
    }

    @Test
    public void testFindById() {
        // Arrange
        Sauce expectedSauce = new Sauce("Tomato", 1.00);
        String id = "1";
        when(repository.findById(id)).thenReturn(Optional.of(expectedSauce));

        // Act
        Sauce actualSauce = service.findById(id);

        // Assert
        assertEquals(expectedSauce, actualSauce);
    }
}
