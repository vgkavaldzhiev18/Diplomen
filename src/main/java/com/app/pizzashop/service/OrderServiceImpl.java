package com.app.pizzashop.service;

import com.app.pizzashop.binding.OrderRegister;
import com.app.pizzashop.entity.AppUser;
import com.app.pizzashop.entity.Order;
import com.app.pizzashop.entity.Pizza;
import com.app.pizzashop.entity.STATUS;
import com.app.pizzashop.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository repository;
    private ModelMapper mapper;
    private UserRepository userRepository;

    private PizzaService pizzaService;

    @Autowired
    public OrderServiceImpl(OrderRepository repository, ModelMapper mapper, UserRepository userRepository, PizzaService pizzaService) {
        this.repository = repository;
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.pizzaService = pizzaService;
    }

    @Override
    public List<Order> findAllByUserAuthIdentifierAndStatus(String authIdentifier, STATUS status) {
        return this.repository.findAllByUserAuthIdentifierAndStatus(authIdentifier, status);
    }

    @Override
    public void createOrder(OrderRegister orderRegister, String authId) {
        Pizza pizza = pizzaService.createPizza(orderRegister.getSizeId(),
                orderRegister.getDoughId(), orderRegister.getToppingsIds(),
                orderRegister.getSaucesIds());
        Order order = new Order();
        order.setOrderTime(LocalDateTime.now());
        order.setUser(userRepository.findByAuthIdentifier(authId));
        order.setPizza(pizza);
        order.setAddress(orderRegister.getDelivery().getAddress());
        order.setPhonenumber(orderRegister.getDelivery().getPhonenumber());
        order.setCity(orderRegister.getDelivery().getCity());
        order.setQuantity(orderRegister.getQuantity());

        order.setStatus(STATUS.INCOMPLETE);
        order.setQuantity(orderRegister.getQuantity());
        order.setPrice(pizza.getPrice() * order.getQuantity());
        repository.save(order);

    }

    @Override
    public void deleteOrder(String orderId) {
        repository.deleteById(orderId);
    }

    @Override
    public void updateOrderStatusForUser(String userId, STATUS status) {
        AppUser user = userRepository.findByAuthIdentifier(userId);

        repository.updateOrdersStatusByUserId(user.getId(),status);
    }
}
