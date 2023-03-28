package com.app.pizzashop.repository;

import com.app.pizzashop.entity.Dough;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoughRepository extends JpaRepository<Dough , String> {

}
