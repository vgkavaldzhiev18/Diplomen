package com.app.pizzashop.repository;

import com.app.pizzashop.entity.Size;
import java.util.*;

public interface SizeService {

    List<Size>findAllSizes();

    Size findById(String id);
}
