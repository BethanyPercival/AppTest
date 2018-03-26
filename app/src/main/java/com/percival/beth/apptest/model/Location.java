package com.percival.beth.apptest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by beth_ on 25/03/2018.
 */

public class Location implements Serializable {
    private String name;
    @SerializedName("hotel_location")
    private String hotelLocation;
    private String description;
    @SerializedName("images")
    private String[] imageUrls;
    private Float rating;
    private String[] facilities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String[] imageUrls) {
        this.imageUrls = imageUrls;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String[] getFacilities() {
        return facilities;
    }

    public void setFacilities(String[] facilities) {
        this.facilities = facilities;
    }
}
