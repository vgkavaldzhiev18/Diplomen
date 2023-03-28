package com.app.pizzashop.repository;

import com.app.pizzashop.entity.AppUser;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<AppUser, String> {

    AppUser findByUsername(String username);

    AppUser findByAuthIdentifier(String authIdentifier);

    List<AppUser> findAllByRolesName(String roleName);

    List<AppUser>findAllByIsEnabled(boolean isEnabled);

    @Transactional
    @Modifying
    @Query("UPDATE AppUser c SET c.firstName = ?2, c.lastName= ?3 WHERE c.authIdentifier = ?1  ")
    void setChanges(String id, String newFirstName, String newLastName);
}
