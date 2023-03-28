package com.app.pizzashop.repository;

import com.app.pizzashop.entity.Dough;

import java.util.*;
public interface DoughService {

    List<Dough>getAllDoughs();
    Dough findById(String id);
}
