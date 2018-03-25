package com.percival.beth.apptest.ui.location;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.percival.beth.apptest.R;
import com.percival.beth.apptest.model.Location;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationFragment extends Fragment implements ILocationView {


    public LocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location, container, false);
    }

    @Override
    public void populateList(Location location) {

    }

    @Override
    public void displayError(String errorMessage) {

    }

    @Override
    public void openHolidayDetailsActivity(Location location) {

    }
}
