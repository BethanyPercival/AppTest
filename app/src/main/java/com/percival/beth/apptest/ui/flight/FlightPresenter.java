package com.percival.beth.apptest.ui.flight;

import com.percival.beth.apptest.network.response.GetFlightsResponse;

/**
 * Created by beth_ on 25/03/2018.
 */

public class FlightPresenter implements IFlightPresenter {

    private IFlightView view;
    private FlightData data;

    public FlightPresenter(IFlightView view, FlightData data) {
        this.view = view;
        this.data = data;
    }

    @Override
    public void onViewReady() {
        data.getFlights(this);
    }

    @Override
    public void onDataReady(GetFlightsResponse getFlightsResponse) {
        if (getFlightsResponse != null) {
            view.populateList(getFlightsResponse);
        } else {
            view.displayError();
        }
    }
}
