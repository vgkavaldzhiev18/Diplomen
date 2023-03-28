package com.app.pizzashop.configuration;

import com.app.pizzashop.entity.AppUser;
import com.app.pizzashop.entity.AuthMethod;
import com.app.pizzashop.entity.Role;
import com.app.pizzashop.repository.RoleRepository;
import com.app.pizzashop.repository.UserRepository;
import com.app.pizzashop.repository.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
        String authType = oauthToken.getAuthorizedClientRegistrationId();
        OAuth2User principal = oauthToken.getPrincipal();
        String authIdentifier = authType.equals("facebook")? principal.getAttribute("id")
                :principal.getAttribute("sub");
        AppUser user = userRepository.findByAuthIdentifier(authIdentifier);
        if(user == null){

            List<Role> userRole = Arrays.asList(roleRepository.findByName("USER"));
            String givenName = null;
            String familyName = null;
            String email = null;

            switch (authType) {
                case "google":
                    givenName = principal.getAttribute("given_name");
                    familyName = principal.getAttribute("family_name");
                    email = principal.getAttribute("email");
                    user = new AppUser(null, givenName, familyName
                            , email,
                            AuthMethod.GOOGLE, null, true, userRole, authIdentifier);
                    break;

                case "facebook":
                    String name = principal.getAttribute("name");
                    String[] spliit = name.split(" ");
                    givenName = spliit[0];
                    familyName = spliit[1];
                    email = principal.getAttribute("email");
                    user = new AppUser(name, givenName, familyName, email,
                            AuthMethod.FACEBOOK, null, true, userRole, authIdentifier) ;
                    break;

            }

            userRepository.save(user);

        }





        redirectStrategy.sendRedirect(request, response, "/order");

    }
}
