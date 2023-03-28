package com.app.pizzashop.service;

import com.app.pizzashop.binding.DeliveryRegistration;
import com.app.pizzashop.binding.ProfileEdit;
import com.app.pizzashop.entity.Role;
import com.app.pizzashop.entity.AppUser;
import com.app.pizzashop.entity.STATUS;
import com.app.pizzashop.entity.UserChange;
import com.app.pizzashop.repository.RoleRepository;
import com.app.pizzashop.repository.UserChangeRepository;
import com.app.pizzashop.repository.UserRepository;
import com.app.pizzashop.repository.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository repository;

    private UserChangeRepository userChangeRepository;
    private ModelMapper mapper;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, UserChangeRepository userChangeRepository, ModelMapper mapper, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.userChangeRepository = userChangeRepository;
        this.mapper = mapper;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserChange> findAllIncompleteUsers() {
        return userChangeRepository.findAllByStatus(STATUS.INCOMPLETE);
    }

    @Override
    public void confirmUser(String id) {
        UserChange byUserAuthId = userChangeRepository.findByUserAuthIdentifierAndStatus(id, STATUS.INCOMPLETE);
        repository.setChanges(id, byUserAuthId.getNewFirstName(), byUserAuthId.getNewLastName());
        userChangeRepository.makeComplete(byUserAuthId.getUser().getId(), STATUS.COMPLETE);
    }

    @Override
    public AppUser findByAuthId(String authId) {

        return this.repository.findByAuthIdentifier(authId);
    }

    @Override
    public void saveEditRequest(String id, ProfileEdit profileEdit) {
        AppUser user = repository.findByAuthIdentifier(id);

        UserChange entity = new UserChange(user, user.getFirstName(), profileEdit.getFirstName(),
                user.getLastName(), profileEdit.getLastName(), STATUS.INCOMPLETE);
        userChangeRepository.save(entity);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username);
    }


}
