package com.percival.beth.apptest.ui.flight;

import com.percival.beth.apptest.network.ApiRequest;
import com.percival.beth.apptest.network.response.GetFlightsResponse;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by beth_ on 25/03/2018.
 */

public class FlightData {
    private GetFlightsResponse getFlightsResponse;
    private ApiRequest apiRequest;

    public FlightData() {
        apiRequest = new ApiRequest();
    }

    public void getFlights(final FlightPresenter presenter) {
        apiRequest.getFlights()
                .subscribeOn(Schedulers.io())
                .onErrorReturnItem(new GetFlightsResponse())
                .subscribe(new Consumer<GetFlightsResponse>() {
                    @Override
                    public void accept(GetFlightsResponse getFlightsResponse) throws Exception {
                        presenter.onDataReady(getFlightsResponse);
                    }
                });
    }
}
