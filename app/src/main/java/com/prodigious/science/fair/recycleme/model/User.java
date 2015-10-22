package com.prodigious.science.fair.recycleme.model;

/**
 * Created by Jorge on 20/10/2015.
 */
public class User {

    private String name;

    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
