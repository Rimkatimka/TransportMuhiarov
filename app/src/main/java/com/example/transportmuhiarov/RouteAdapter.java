package com.example.transportmuhiarov;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.transportmuhiarov.R;
import com.example.transportmuhiarov.Route;

import java.util.List;

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.RouteViewHolder> {
    private List<Route> routeList;

    public RouteAdapter(List<Route> routeList) {
        this.routeList = routeList;
    }

    @NonNull
    @Override
    public RouteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_route, parent, false);
        return new RouteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RouteViewHolder holder, int position) {
        Route route = routeList.get(position);
        holder.tvFromTo.setText(route.getFrom() + " → " + route.getTo());
        holder.tvDeparture.setText("Отправление: " + route.getDepartureTime());
        holder.tvArrival.setText("Прибытие: " + route.getArrivalTime());
        holder.tvTransportType.setText("Транспорт: " + route.getTransportType());
    }

    @Override
    public int getItemCount() {
        return routeList.size();
    }

    static class RouteViewHolder extends RecyclerView.ViewHolder {
        TextView tvFromTo, tvDeparture, tvArrival, tvTransportType;

        public RouteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFromTo = itemView.findViewById(R.id.tvFromTo);
            tvDeparture = itemView.findViewById(R.id.tvDeparture);
            tvArrival = itemView.findViewById(R.id.tvArrival);
            tvTransportType = itemView.findViewById(R.id.tvTransportType);
        }
    }
}
