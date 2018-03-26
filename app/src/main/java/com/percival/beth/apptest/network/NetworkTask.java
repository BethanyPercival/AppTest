package com.percival.beth.apptest.network;

import com.percival.beth.apptest.model.Location;
import com.percival.beth.apptest.network.response.GetFlightsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by beth_ on 24/03/2018.
 */

public interface NetworkTask {

    @GET("f0Tm6bfy")
    Single<Location> getLocations();

    @GET("bFnZQEx0")
    Single<GetFlightsResponse> getFlights();
}
