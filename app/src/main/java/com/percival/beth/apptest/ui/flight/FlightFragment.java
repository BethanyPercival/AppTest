package com.percival.beth.apptest.ui.flight;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.percival.beth.apptest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FlightFragment extends Fragment implements IFlightView {


    public FlightFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flight, container, false);
    }

}
