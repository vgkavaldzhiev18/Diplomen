package com.app.pizzashop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Topping extends BaseEntity{
    public Topping(String name, double price) {
        this.name = name;
        this.price = price;
    }

    private String name;
    private double price;

    @Override
    public String toString() {
        return String.format("%s - %.2fлв.", name, price);
    }



}
