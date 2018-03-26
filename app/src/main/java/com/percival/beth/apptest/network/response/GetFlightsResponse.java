package com.percival.beth.apptest.network.response;

import com.google.gson.annotations.SerializedName;
import com.percival.beth.apptest.model.Flight;

import java.util.ArrayList;

/**
 * Created by beth_ on 25/03/2018.
 */

public class GetFlightsResponse {
    @SerializedName("flights")
    private ArrayList<Flight> FlightList;

    public ArrayList<Flight> getFlightList() {
        return FlightList;
    }

    public void setFlightList(ArrayList<Flight> flightList) {
        FlightList = flightList;
    }
}
