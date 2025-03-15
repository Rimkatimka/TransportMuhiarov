package com.example.transportmuhiarov;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.transportmuhiarov.BookingAdapter;

import java.util.ArrayList;
import java.util.List;

public class BookingsFragment extends Fragment {
    private RecyclerView recyclerView;
    private BookingAdapter adapter;
    private List<Booking> bookingList;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookings, container, false);
        recyclerView = view.findViewById(R.id.recycler_bookings);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Пример данных
        bookingList = new ArrayList<>();
        bookingList.add(new Booking("Москва - Санкт-Петербург", "10 марта 2025", "12:30"));
        bookingList.add(new Booking("Казань - Екатеринбург", "15 марта 2025", "08:45"));

        adapter = new BookingAdapter(getContext(), bookingList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
