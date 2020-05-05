package com.rg.eventappweb.services;

import com.rg.eventappweb.models.UserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDetailsServiceTest {
    @Autowired
    private UserDetailsService userDetailsService;

    @Test
    public void should_return_true_when_user_exist_and_password_match(){
        UserDetails user = new UserDetails("mimi@mimi","mimi");
        boolean autenticated = userDetailsService.isAutenticated(user);
        assertTrue(autenticated);
    }

    @Test
    public void should_return_false_when_user_exist_and_password_does_not_match()
    {
        UserDetails user = new UserDetails("mimi@mimi","riri");
        boolean autenticated = userDetailsService.isAutenticated(user);
        assertFalse(autenticated);

    }

    @Test
    public void should_return_false_when_user_does_not_exist()
    {
        UserDetails user = new UserDetails("toto","riri");
        boolean autenticated = userDetailsService.isAutenticated(user);
        assertFalse(autenticated);
    }

}