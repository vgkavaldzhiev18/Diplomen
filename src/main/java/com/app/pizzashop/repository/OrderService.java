package com.app.pizzashop.repository;

import com.app.pizzashop.binding.OrderRegister;
import com.app.pizzashop.entity.Order;
import com.app.pizzashop.entity.STATUS;
import jdk.jshell.Snippet;

import java.util.List;

public interface OrderService {
    List<Order> findAllByUserAuthIdentifierAndStatus(String authIdentifier, STATUS status);

    void createOrder(OrderRegister orderRegister, String authId);

    void deleteOrder(String orderId);

    void updateOrderStatusForUser(String userId, STATUS status);

}
