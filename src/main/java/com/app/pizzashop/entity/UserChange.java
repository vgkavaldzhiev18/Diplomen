package com.app.pizzashop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserChange extends BaseEntity{

    public UserChange(AppUser user, String oldFirstName, String newFirstName, String oldLastName, String newLastName, STATUS status) {
        this.user = user;
        this.oldFirstName = oldFirstName;
        this.newFirstName = newFirstName;
        this.oldLastName = oldLastName;
        this.newLastName = newLastName;
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser user;
    @Column
    private String oldFirstName;
    @Column
    private String newFirstName;
    @Column
    private String oldLastName;
    @Column
    private String newLastName;

    @Enumerated(EnumType.STRING)
    private STATUS status;
}
