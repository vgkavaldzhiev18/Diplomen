package com.app.pizzashop.repository;

import com.app.pizzashop.entity.Order;
import com.app.pizzashop.entity.STATUS;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    List<Order>findAllByUserAuthIdentifierAndStatus(String authIdentifier, STATUS status);

    @Modifying
    @Transactional
    @Query("UPDATE Order  SET status = ?2 " +
            "WHERE user.id = ?1 and  status = 'INCOMPLETE'")
    void updateOrdersStatusByUserId(String userId, STATUS status);
}
