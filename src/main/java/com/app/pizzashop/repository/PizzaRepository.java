package com.app.pizzashop.repository;

import com.app.pizzashop.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository
        extends JpaRepository<Pizza, String> {
}
