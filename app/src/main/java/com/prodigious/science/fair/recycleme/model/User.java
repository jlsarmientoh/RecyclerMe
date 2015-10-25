package com.prodigious.science.fair.recycleme.model;

/**
 * Created by Jorge on 20/10/2015.
 */
public class User {

    private String name;

    private String email;

    private int score;

    public User(String name, String email, int score) {
        this.name = name;
        this.email = email;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getScore() {
        return score;
    }
}
