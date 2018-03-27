package com.percival.beth.apptest.ui.location;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.percival.beth.apptest.R;
import com.percival.beth.apptest.model.Location;
import com.percival.beth.apptest.utils.AddViewsToAnotherView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by beth_ on 25/03/2018.
 */

public class LocationRecyclerViewAdapter extends RecyclerView.Adapter<LocationRecyclerViewAdapter.ViewHolder> {

    private Location locationList;
    private ILocationPresenter presenter;
    private Context context;

    public LocationRecyclerViewAdapter(Location locationList, ILocationPresenter presenter, Context context) {
        this.locationList = locationList;
        this.presenter = presenter;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_location, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Location location = locationList;
        holder.setHotelName(location.getName());
        holder.setLocationName(location.getHotelLocation());
        holder.setRating(location.getRating());
        AddViewsToAnotherView.addImageViewsToLinearLayout(location.getImageUrls(), holder.linearLayoutImages, context);
        holder.constraintLayoutRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.listItemSelected(location);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (locationList != null) {
            return 1;
        } else {
            return 0;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view_hotel_name)
        TextView textViewHotelName;
        @BindView(R.id.text_view_location)
        TextView textViewLocation;
        @BindView(R.id.rating_bar)
        RatingBar ratingBar;
        @BindView(R.id.linear_layout_images)
        LinearLayout linearLayoutImages;
        @BindView(R.id.root_view)
        ConstraintLayout constraintLayoutRootView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setHotelName(String hotelName) {
            this.textViewHotelName.setText(hotelName);
        }

        public void setLocationName(String location) {
            this.textViewLocation.setText(location);
        }

        public void setRating(float rating) {
            this.ratingBar.setRating(rating);
        }
    }
}
