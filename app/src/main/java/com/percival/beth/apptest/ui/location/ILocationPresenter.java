package com.percival.beth.apptest.ui.location;

import com.percival.beth.apptest.model.Location;

/**
 * Created by beth_ on 25/03/2018.
 */

public interface ILocationPresenter {
    void onViewReady();

    void onDataReady(Location getLocationsResponse);

    void listItemSelected(int listItemPosition);
}
