package com.prodigious.science.fair.recycleme.model;

/**
 * Created by jsarmien on 10/22/15.
 */
public class Goal {

    private String description;
    private String imageUrl;
    private int points;

    public Goal(String description, String imageUrl, int points) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getPoints() {
        return points;
    }
}
