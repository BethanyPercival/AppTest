package com.percival.beth.apptest.ui.location;

import com.percival.beth.apptest.network.response.GetLocationsResponse;

/**
 * Created by beth_ on 25/03/2018.
 */

public class LocationPresenter implements ILocationPresenter {

    private ILocationView view;
    private LocationData data;

    public LocationPresenter(ILocationView view, LocationData data) {
        this.view = view;
        this.data = data;
    }

    public void onViewReady() {
        data.getLocations();
    }

    public void onDataReady(GetLocationsResponse getLocationsResponse) {

    }

    @Override
    public void onDataError(String errorMessage) {

    }

    @Override
    public void listItemSelected(int listItemPosition) {

    }
}
