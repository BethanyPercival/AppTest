package com.percival.beth.apptest.ui.holidaydetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.percival.beth.apptest.R;
import com.percival.beth.apptest.model.Location;
import com.percival.beth.apptest.utils.AddViewsToAnotherView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by beth_ on 26/03/2018.
 */

public class HolidayDetailsActivity extends AppCompatActivity {

    @BindView(R.id.text_view_hotel_name)
    TextView textViewHotelName;
    @BindView(R.id.text_view_location)
    TextView textViewLocation;
    @BindView(R.id.rating_bar)
    RatingBar ratingBar;
    @BindView(R.id.text_view_description)
    TextView textViewDescription;
    @BindView(R.id.linear_layout_images)
    LinearLayout linearLayoutImages;
    @BindView(R.id.linear_layout_facilities)
    LinearLayout linearLayoutFacilities;

    public static final String EXTRA_LOCATION = "com.percival.beth.apptest.ui.holidaydetails.extra_location";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday_details);
        ButterKnife.bind(this);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        displayData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displayData() {
        Location location = (Location) getIntent().getSerializableExtra(EXTRA_LOCATION);
        textViewHotelName.setText(location.getName());
        textViewLocation.setText(location.getHotelLocation());
        ratingBar.setRating(location.getRating());
        textViewDescription.setText(location.getDescription());
        AddViewsToAnotherView.addImageViewsToLinearLayout(location.getImageUrls(), linearLayoutImages, this);
        AddViewsToAnotherView.addTextViewsToLinearLayout(location.getFacilities(), linearLayoutFacilities, this);
    }
}
