package com.example.transportmuhiarov;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ResultsFragment extends Fragment {
    private RecyclerView recyclerRoutes;
    private RouteAdapter routeAdapter;
    private List<Route> routeList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_results, container, false);

        recyclerRoutes = view.findViewById(R.id.recyclerRoutes);
        recyclerRoutes.setLayoutManager(new LinearLayoutManager(getContext()));

        // Получаем данные из SearchFragment
        Bundle bundle = getArguments();
        if (bundle != null) {
            String from = bundle.getString("from");
            String to = bundle.getString("to");
            String date = bundle.getString("date");
            String time = bundle.getString("time");
            String transport = bundle.getString("transport");

            // Загружаем найденные маршруты (Здесь просто заглушка)
            loadRoutes(from, to, date, time, transport);
        }

        return view;
    }

    private void loadRoutes(String from, String to, String date, String time, String transport) {
        routeList = new ArrayList<>();

        // Пример данных
        routeList.add(new Route(from, to, time, "14:30", transport));
        routeList.add(new Route(from, to, "15:00", "18:20", transport));
        routeList.add(new Route(from, to, "16:30", "20:45", transport));

        routeAdapter = new RouteAdapter(routeList);
        recyclerRoutes.setAdapter(routeAdapter);
    }
}
