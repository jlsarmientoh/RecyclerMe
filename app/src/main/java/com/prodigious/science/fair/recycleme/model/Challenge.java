package com.prodigious.science.fair.recycleme.model;

/**
 * Created by jsarmien on 10/23/15.
 */
public class Challenge {

    private String description;

    private String imageUrl;

    private int requiredCaps;


    public Challenge(String description, String imageUrl, int requiredCaps) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.requiredCaps = requiredCaps;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getRequiredCaps() {
        return requiredCaps;
    }
}
