package com.app.pizzashop.repository;

import com.app.pizzashop.entity.Sauce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SauceRepository extends JpaRepository<Sauce, String> {
}
