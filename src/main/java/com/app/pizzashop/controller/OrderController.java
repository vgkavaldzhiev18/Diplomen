package com.app.pizzashop.controller;

import com.app.pizzashop.binding.OrderRegister;
import com.app.pizzashop.entity.Order;
import com.app.pizzashop.entity.STATUS;
import com.app.pizzashop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    private DoughService doughService;
    private ToppingService toppingService;
    private SizeService sizeService;
    private SauceService sauceService;
    private OrderService service;

    @Autowired
    public OrderController(DoughService doughService, ToppingService toppingService, SizeService sizeService, SauceService sauceService, OrderService service) {
        this.doughService = doughService;
        this.toppingService = toppingService;
        this.sizeService = sizeService;
        this.sauceService = sauceService;
        this.service = service;
    }

    @GetMapping
    public String home(Model model) {

        model.addAttribute("doughs", doughService.getAllDoughs());
        model.addAttribute("toppings", toppingService.findAllToppings());
        model.addAttribute("sizes", sizeService.findAllSizes());
        model.addAttribute("sauces", sauceService.findALlSauces());
        model.addAttribute("order", new OrderRegister());
        return "home";
    }
    @PostMapping
    public String handleOrder(@ModelAttribute OrderRegister order, RedirectAttributes redirectAttributes,
                              Authentication authentication){
        service.createOrder( order, authentication.getName());
        redirectAttributes.addFlashAttribute("orderSuccess", true);

        return "redirect:/order";
    }

    @GetMapping("/cart/{id}")
    public String cart(@PathVariable String id, Model model){
        List<Order> allByUserAuthIdentifierAndStatus = this.service.findAllByUserAuthIdentifierAndStatus(id, STATUS.INCOMPLETE);
        model.addAttribute("orders", allByUserAuthIdentifierAndStatus);
        model.addAttribute("total",allByUserAuthIdentifierAndStatus.
                stream().mapToDouble(Order::getPrice).sum());
        return "cart";
    }

    @PostMapping("/cart/{id}")
    public String purchase(@PathVariable String id, Authentication authentication,
                           RedirectAttributes redirectAttributes){
        service.updateOrderStatusForUser(id, STATUS.COMPLETE);
        redirectAttributes.addFlashAttribute("orderSuccess", true);
        return "redirect:/order/cart/" + authentication.getName();
    }

    @GetMapping("/cart/delete/{id}")
    public String deleteOrder(@PathVariable String id,  Authentication authentication){
        service.deleteOrder(id);
        return "redirect:/order/cart/" + authentication.getName();
    }


    @ModelAttribute("auth")
    public Authentication requestURI(final Authentication authentication) {
        return authentication;
    }
}
