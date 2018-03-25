package com.percival.beth.apptest.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.percival.beth.apptest.model.Location;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by beth_ on 24/03/2018.
 */

public class ApiRequest {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://pastebin.com/raw/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public Single<Location> getLocations() {
        NetworkTask networkTask = retrofit.create(NetworkTask.class);
        return networkTask.getLocations();
    }
}
