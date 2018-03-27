package com.percival.beth.apptest.ui.flight;

import com.percival.beth.apptest.network.response.GetFlightsResponse;

/**
 * Created by beth_ on 25/03/2018.
 */

public interface IFlightPresenter {
    void onViewReady();

    void onDataReady(GetFlightsResponse getFlightsResponse);
}
