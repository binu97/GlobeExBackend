package com.model;

public class Destination {

    private String id;
    private String description;
    private String name;
    private String distanceFromAirport;
    private String town;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistanceFromAirport(String distanceFromAirport) {
        this.distanceFromAirport = distanceFromAirport;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
