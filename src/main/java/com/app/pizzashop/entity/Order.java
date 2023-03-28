package com.app.pizzashop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "pizza_orders")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Order extends BaseEntity{

    @Column
    private LocalDateTime orderTime;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser user;
    @Column
    private double price;

    @ManyToOne
    @JoinColumn(name = "pizza_id", referencedColumnName = "id")
    private Pizza pizza;
    @Column
    private String address;
    @Column
    private String phonenumber;
    @Column
    private String city;
    @Column
    private int quantity;

    @Enumerated(EnumType.STRING)
    private STATUS status;
}
