package com.app.pizzashop.initialization;

import com.app.pizzashop.entity.Role;
import com.app.pizzashop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RolesInit implements CommandLineRunner {

    private RoleRepository repository;


    @Autowired
    public RolesInit(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(repository.count() == 0){
            Role adminRole = new Role("ADMIN");
            Role userRole = new Role("CUSTOMER");
            repository.save(adminRole);
            repository.save(userRole);
        }
    }
}
