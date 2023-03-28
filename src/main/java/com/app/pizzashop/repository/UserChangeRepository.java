package com.app.pizzashop.repository;

import com.app.pizzashop.entity.STATUS;
import com.app.pizzashop.entity.UserChange;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface UserChangeRepository extends JpaRepository<UserChange, String> {

    List<UserChange>findAllByStatus(STATUS status);

    UserChange findByUserAuthIdentifierAndStatus(String authId,STATUS status);

    @Transactional
    @Modifying
    @Query("UPDATE UserChange SET status = ?2 WHERE user.id = ?1  ")
    void makeComplete(String id, STATUS status);
}
