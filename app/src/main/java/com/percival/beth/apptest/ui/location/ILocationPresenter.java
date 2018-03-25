package com.percival.beth.apptest.ui.location;

import com.percival.beth.apptest.network.response.GetLocationsResponse;

/**
 * Created by beth_ on 25/03/2018.
 */

public interface ILocationPresenter {
    void onViewReady();

    void onDataReady(GetLocationsResponse getLocationsResponse);

    void onDataError(String errorMessage);

    void listItemSelected(int listItemPosition);
}
