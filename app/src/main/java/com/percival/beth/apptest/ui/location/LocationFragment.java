package com.percival.beth.apptest.ui.location;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.percival.beth.apptest.R;
import com.percival.beth.apptest.model.Location;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocationFragment extends Fragment implements ILocationView {

    @BindView(R.id.recycler_view_location)
    RecyclerView recyclerViewLocation;

    private ILocationPresenter presenter;
    private LocationRecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location, container, false);
        ButterKnife.bind(this, view);
        presenter = new LocationPresenter(this, new LocationData());
        initialiseRecyclerView();
        presenter.onViewReady();
        return view;
    }

    @Override
    public void populateList(final Location locationList) {
        getActivity().runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        recyclerViewLocation.setAdapter(new LocationRecyclerViewAdapter(locationList, presenter, getContext()));
                    }
                }

        );
    }

    @Override
    public void displayError() {
//        context.getString(R.string.error_generic_try_again_later)
    }

    @Override
    public void openHolidayDetailsActivity(Location location) {

    }

    public LocationFragment() {
        // Required empty public constructor
    }

    private void initialiseRecyclerView() {
        adapter = new LocationRecyclerViewAdapter(null, presenter, getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewLocation.setLayoutManager(layoutManager);
        recyclerViewLocation.setAdapter(adapter);
    }
}
