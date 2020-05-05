package com.rg.eventappweb.repositories;

import com.rg.eventappweb.models.UserDetails;

import java.util.Optional;

public interface UserDetailsRepository {

    public Optional<UserDetails> findUser(UserDetails user);

}
