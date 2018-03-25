package com.percival.beth.apptest.ui.location;

import com.percival.beth.apptest.model.Location;
import com.percival.beth.apptest.network.ApiRequest;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by beth_ on 25/03/2018.
 */

public class LocationData {
    private Location locationList;
    private ApiRequest apiRequest;

    LocationData() {
        this.apiRequest = new ApiRequest();
    }

    public void getLocations(final ILocationPresenter presenter) {
        apiRequest.getLocations()
                .subscribeOn(Schedulers.io())
                .onErrorReturnItem(null)
                .subscribe(new Consumer<Location>() {
                    @Override
                    public void accept(Location getLocationsResponse) throws Exception {
                        presenter.onDataReady(getLocationsResponse);
                        locationList = getLocationsResponse;
                    }
                });
    }

    public Location getLocationDetails(int listItemPosition) {
        return locationList;
    }
}
