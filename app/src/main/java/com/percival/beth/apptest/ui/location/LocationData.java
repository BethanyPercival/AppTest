package com.percival.beth.apptest.ui.location;

import com.percival.beth.apptest.model.Location;
import com.percival.beth.apptest.network.ApiRequest;
import com.percival.beth.apptest.network.response.GetLocationsResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by beth_ on 25/03/2018.
 */

public class LocationData {
    private List<Location> locationList = new ArrayList<>();
    private ApiRequest apiRequest;

    public void getLocations(final ILocationPresenter presenter) {
        apiRequest.getLocations()
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<GetLocationsResponse>() {
                   @Override
                    public void accept(GetLocationsResponse getLocationsResponse) throws Exception {
                       presenter.onDataReady(getLocationsResponse);
                   }
                });
    }

    public Location getLocationDetails(int listItemPosition) {
        return locationList.get(listItemPosition);
    }
}
