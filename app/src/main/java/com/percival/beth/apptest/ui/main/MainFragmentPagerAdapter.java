package com.percival.beth.apptest.ui.main;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.percival.beth.apptest.R;
import com.percival.beth.apptest.ui.flight.FlightFragment;
import com.percival.beth.apptest.ui.location.LocationFragment;

/**
 * Created by beth_ on 24/03/2018.
 */

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public MainFragmentPagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new FlightFragment();
            default:
                return new LocationFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 1:
                return context.getString(R.string.title_flight);
            default:
                return context.getString(R.string.title_location);
        }
    }
}
