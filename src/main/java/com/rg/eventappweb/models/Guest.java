package com.rg.eventappweb.models;

import java.util.UUID;

public class Guest {

    private String id;
    private String email;


    public Guest() {
        this.id = UUID.randomUUID().toString();
    }

    public Guest(String email) {
        this();
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "Guest{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
