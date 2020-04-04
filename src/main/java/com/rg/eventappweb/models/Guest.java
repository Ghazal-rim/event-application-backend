package com.rg.eventappweb.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Guest {
    @Id
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


    @Override
    public String toString() {
        return "Guest{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
