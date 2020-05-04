package com.rg.eventappweb.repositories;

import com.rg.eventappweb.models.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryUserDetailsRepository implements UserDetailsRepository {

    Map<String, UserDetails> users = new HashMap<>();


    public InMemoryUserDetailsRepository() {

        insert("gigi@gigi", "gigi");
        insert("mimi@mimi", "mimi");
    }

    private void insert(String email, String password) {
        users.put(email, new UserDetails(email, password));
    }


    @Override
    public Optional<UserDetails> findUser(UserDetails user) {
        if (users.containsKey(user.getEmail())) return Optional.of(users.get(user.getEmail()));
        return Optional.empty();

    }


}
