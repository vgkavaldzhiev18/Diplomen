package com.app.pizzashop.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

@Table
@Entity
@Data
@NoArgsConstructor
public class Role extends BaseEntity implements GrantedAuthority {

    public Role(String name) {
        this.name = name;
    }



    @Column
    private String name;

    //vrushtame imeto na rolqta
    @Override
    public String getAuthority() {
        return name;
    }
}
