package com.percival.beth.apptest.ui.flight;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.percival.beth.apptest.R;
import com.percival.beth.apptest.model.Flight;
import com.squareup.picasso.Picasso;

import org.joda.time.DateTime;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by beth_ on 25/03/2018.
 */

public class FlightRecyclerViewAdapter extends RecyclerView.Adapter<FlightRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Flight> flightList;
    private IFlightPresenter presenter;
    private Context context;

    public FlightRecyclerViewAdapter(ArrayList<Flight> flightList, IFlightPresenter presenter, Context context) {
        this.flightList = flightList;
        this.presenter = presenter;
        this.context = context;
    }

    @NonNull
    @Override
    public FlightRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_flight, parent, false);
        return new FlightRecyclerViewAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightRecyclerViewAdapter.ViewHolder holder, int position) {
        Flight flight = flightList.get(position);
        holder.setFlightLocation(flight.getDepartureAirport() + " to " + flight.getArrivalAirport());
        holder.setFlightDate();
        holder.setAirline(flight.getAirline());
        holder.setPrice(String.valueOf(flight.getPrice()));
    }

    @Override
    public int getItemCount() {
        if (flightList != null) {
            return flightList.size();
        } else {
            return 0;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view_flight_location)
        TextView textViewFlightLocation;
        @BindView(R.id.text_view_flight_date)
        TextView textViewFlightDate;
        @BindView(R.id.text_view_airline)
        TextView textViewAirline;
        @BindView(R.id.text_view_price)
        TextView textViewPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setFlightLocation(String flightLocation) {
            this.textViewFlightLocation.setText(flightLocation);
        }

        public void setFlightDate(String flightDate) {
            this.textViewFlightDate.setText(flightDate);
        }

        public void setAirline(String airline) {
            this.textViewAirline.setText(airline);
        }

        public void setPrice(String price) {
            this.textViewPrice.setText(price);
        }

        public String convertIsoDateTime(String dateTime) {
            return new DateTime( "2010-01-01T12:00:00+01:00" ) ;
//            jodatime
        }
    }
}
