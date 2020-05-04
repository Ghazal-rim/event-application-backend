package com.rg.eventappweb.services;

import com.rg.eventappweb.models.UserDetails;
import com.rg.eventappweb.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public boolean isAutenticated(UserDetails user) {
        Optional<UserDetails> userOptional = userDetailsRepository.findUser(user);
        if (userOptional.isPresent()) {
            return isPasswordMatching(user.getPassword(), userOptional.get().getPassword());

        }
        return false;
    }

    private boolean isPasswordMatching(String password, String comparedPassword) {
        return password.equals(comparedPassword);
    }

}
