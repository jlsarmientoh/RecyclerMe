package com.prodigious.science.fair.recycleme.model;

/**
 * Created by jsarmien on 10/23/15.
 */
public class Challenge {

    private String description;

    private String imageUrl;


    public Challenge(String description, String imageUrl) {
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
