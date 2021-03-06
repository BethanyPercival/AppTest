package com.percival.beth.apptest.ui.location;

import com.percival.beth.apptest.model.Location;

/**
 * Created by beth_ on 25/03/2018.
 */

public interface ILocationView {
    void populateList(Location locationList);

    void displayError();

    void openHolidayDetailsActivity(Location location);
}
