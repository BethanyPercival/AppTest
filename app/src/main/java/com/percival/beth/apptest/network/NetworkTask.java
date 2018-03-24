package com.percival.beth.apptest.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by beth_ on 24/03/2018.
 */

public interface NetworkTask {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("pastebin.com/raw/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
