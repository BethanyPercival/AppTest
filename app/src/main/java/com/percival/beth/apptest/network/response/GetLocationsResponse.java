package com.percival.beth.apptest.network.response;

import com.percival.beth.apptest.model.Location;

import java.util.ArrayList;

/**
 * Created by beth_ on 25/03/2018.
 */

public class GetLocationsResponse {
    private ArrayList<Location> LocationList;

    public ArrayList<Location> getLocationList() {
        return LocationList;
    }

    public void setLocationsArray(ArrayList<Location> locationList) {
        LocationList = locationList;
    }
}
