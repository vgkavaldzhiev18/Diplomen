package com.app.pizzashop.repository;

import com.app.pizzashop.binding.DeliveryRegistration;
import com.app.pizzashop.binding.ProfileEdit;
import com.app.pizzashop.entity.AppUser;
import com.app.pizzashop.entity.UserChange;

import java.util.List;

public interface UserService {

    List<UserChange> findAllIncompleteUsers();

    void confirmUser(String authId);

    AppUser findByAuthId(String authId);

    void saveEditRequest(String id, ProfileEdit profileEdit);

}
