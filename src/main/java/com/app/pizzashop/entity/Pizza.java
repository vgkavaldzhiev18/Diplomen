package com.app.pizzashop.entity;

import jakarta.persistence.*;

import java.util.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pizza extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "dough_id", referencedColumnName = "id")
    private Dough dough;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pizza_sauce",
            joinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "sauce_id", referencedColumnName = "id")
    )
    private List<Sauce> sauce;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pizza_topping",
            joinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id", referencedColumnName = "id")
    )
    private List<Topping>toppings;

    @ManyToOne
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    private Size size;

    @Column
    private double price;
}
