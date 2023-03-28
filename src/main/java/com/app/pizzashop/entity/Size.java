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
public class Size extends BaseEntity{

    public Size(int size, double price) {
        this.size = size;
        this.price = price;
    }

    private int size;

    private double price;

    @Override
    public String toString() {
        return String.format("%dcm - %.2fлв.", size, price);
    }
}
