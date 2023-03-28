package com.app.pizzashop.initialization;

import com.app.pizzashop.entity.AuthMethod;
import com.app.pizzashop.entity.Role;
import com.app.pizzashop.entity.AppUser;
import com.app.pizzashop.repository.RoleRepository;
import com.app.pizzashop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserInit implements CommandLineRunner {

    private UserRepository repository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserInit(UserRepository repository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        List<AppUser> admins = repository.findAllByRolesName("ADMIN");
        if(admins.size() == 0){
            List<Role> all = roleRepository.findAll();
//            List<Role> userRole = Arrays.asList(roleRepository.findByName("USER"));
            AppUser admin = new AppUser("Admin","Admin","Admin","admin@abv.bg", AuthMethod.FORM,passwordEncoder.encode("1234"),
                    true,all, "000000000000000000001");

            repository.save(admin);

        }
    }
}
