package com.percival.beth.apptest.ui.location;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.percival.beth.apptest.R;
import com.percival.beth.apptest.model.Location;
import com.percival.beth.apptest.ui.holidaydetails.HolidayDetailsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.percival.beth.apptest.ui.holidaydetails.HolidayDetailsActivity.EXTRA_LOCATION;

public class LocationFragment extends Fragment implements ILocationView {

    @BindView(R.id.recycler_view_location)
    RecyclerView recyclerViewLocation;
    @BindView(R.id.root_view)
    FrameLayout rootView;

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
        Snackbar snackbar = Snackbar
                .make(rootView, getContext().getString(R.string.error_generic_try_again_later), Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @Override
    public void openHolidayDetailsActivity(Location location) {
        Intent intent = new Intent(getActivity(), HolidayDetailsActivity.class);
        intent.putExtra(EXTRA_LOCATION, location);
        startActivity(intent);
    }

    public LocationFragment() {
        // Required empty public constructor
    }

    private void initialiseRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewLocation.setLayoutManager(layoutManager);
    }
}
