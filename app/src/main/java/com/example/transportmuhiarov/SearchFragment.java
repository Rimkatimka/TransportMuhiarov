package com.example.transportmuhiarov;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.transportmuhiarov.R;

import java.util.Calendar;

public class SearchFragment extends Fragment {
    private EditText etFrom, etTo;
    private Button btnSelectDate, btnSelectTime, btnSearch;
    private Spinner spinnerTransport;
    private String selectedDate = "", selectedTime = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        etFrom = view.findViewById(R.id.etFrom);
        etTo = view.findViewById(R.id.etTo);
        btnSelectDate = view.findViewById(R.id.btnSelectDate);
        btnSelectTime = view.findViewById(R.id.btnSelectTime);
        btnSearch = view.findViewById(R.id.btnSearch);
        spinnerTransport = view.findViewById(R.id.spinnerTransport);

        // Выбор даты
        btnSelectDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), (view1, year, month, dayOfMonth) -> {
                selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                btnSelectDate.setText(selectedDate);
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        });

        // Выбор времени
        btnSelectTime.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), (view12, hourOfDay, minute) -> {
                selectedTime = hourOfDay + ":" + minute;
                btnSelectTime.setText(selectedTime);
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
            timePickerDialog.show();
        });

        // Обработка нажатия "Найти"
        btnSearch.setOnClickListener(v -> {
            String from = etFrom.getText().toString().trim();
            String to = etTo.getText().toString().trim();
            String transport = spinnerTransport.getSelectedItem().toString();

            if (from.isEmpty() || to.isEmpty() || selectedDate.isEmpty() || selectedTime.isEmpty()) {
                Toast.makeText(getContext(), "Заполните все поля!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Переход к списку маршрутов
            Bundle bundle = new Bundle();
            bundle.putString("from", from);
            bundle.putString("to", to);
            bundle.putString("date", selectedDate);
            bundle.putString("time", selectedTime);
            bundle.putString("transport", transport);

            ResultsFragment resultsFragment = new ResultsFragment();
            resultsFragment.setArguments(bundle);

            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, resultsFragment)
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }
}
