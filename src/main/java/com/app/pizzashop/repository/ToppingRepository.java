package com.app.pizzashop.repository;

import com.app.pizzashop.entity.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, String> {


}
