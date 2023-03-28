package com.app.pizzashop.binding;

import com.app.pizzashop.entity.Dough;
import com.app.pizzashop.entity.Sauce;
import com.app.pizzashop.entity.Size;
import com.app.pizzashop.entity.Topping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRegister {

    private String sizeId;
    private String doughId;
    private List<String> toppingsIds;
    private List<String>saucesIds;

    private DeliveryRegistration delivery;


    private int quantity;
}
