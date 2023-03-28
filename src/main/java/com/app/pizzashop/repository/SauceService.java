package com.app.pizzashop.repository;

import com.app.pizzashop.entity.Sauce;
import java.util.*;
public interface SauceService {

    List<Sauce>findALlSauces();

    Sauce findById(String id);
}
