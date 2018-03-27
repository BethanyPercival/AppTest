package com.percival.beth.apptest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by beth_ on 25/03/2018.
 */

public class Flight {
    private String airline;
    @SerializedName("departure_date")
    private String departureDate;
    @SerializedName("arrival_date")
    private String arrivalDate;
    private int price;
    @SerializedName("departure_airport")
    private String departureAirport;
    @SerializedName("arrival_airport")
    private String arrivalAirport;

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
}
