package com.percival.beth.apptest.ui.location;

import com.percival.beth.apptest.model.Location;

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
        data.getLocations(this);
    }

    public void onDataReady(Location getLocationsResponse) {
        if (getLocationsResponse.getName() != null) {
            view.populateList(getLocationsResponse);
        } else {
            view.displayError();
        }
    }

    @Override
    public void listItemSelected(int listItemPosition) {

    }
}
