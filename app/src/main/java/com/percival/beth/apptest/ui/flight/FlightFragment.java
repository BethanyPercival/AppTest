package com.percival.beth.apptest.ui.flight;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.percival.beth.apptest.R;
import com.percival.beth.apptest.network.response.GetFlightsResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlightFragment extends Fragment implements IFlightView {

    @BindView(R.id.recycler_view_flight)
    RecyclerView recyclerViewFlight;

    private IFlightPresenter presenter;
    private FlightRecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flight, container, false);
        ButterKnife.bind(this, view);
        presenter = new FlightPresenter(this, new FlightData());
        initialiseRecyclerView();
        presenter.onViewReady();
        return view;
    }

    @Override
    public void populateList(final GetFlightsResponse getFlightsResponse) {
        getActivity().runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        recyclerViewFlight.setAdapter(new FlightRecyclerViewAdapter(getFlightsResponse.getFlightList()));
                    }
                }
        );
    }

    @Override
    public void displayError() {

    }

    public FlightFragment() {
        // Required empty public constructor
    }

    private void initialiseRecyclerView() {
        adapter = new FlightRecyclerViewAdapter(null);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewFlight.setLayoutManager(layoutManager);
        recyclerViewFlight.setAdapter(adapter);
    }
}
