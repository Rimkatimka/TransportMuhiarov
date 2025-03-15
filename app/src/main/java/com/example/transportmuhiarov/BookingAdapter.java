package com.example.transportmuhiarov;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.transportmuhiarov.R;

import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.BookingViewHolder> {
    private List<Booking> bookings;
    private Context context;

    public BookingAdapter(Context context, List<Booking> bookings) {
        this.context = context;
        this.bookings = bookings;
    }

    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_booking, parent, false);
        return new BookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position) {
        Booking booking = bookings.get(position);
        holder.tvRoute.setText("Маршрут: " + booking.getRoute());
        holder.tvDate.setText("Дата: " + booking.getDate());
        holder.tvTime.setText("Время: " + booking.getTime());

        holder.btnCancel.setOnClickListener(v -> {
            // Обработчик нажатия кнопки "Отменить бронь"
            Toast.makeText(context, "Бронь отменена", Toast.LENGTH_SHORT).show();
            bookings.remove(position);
            notifyItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return bookings.size();
    }

    public static class BookingViewHolder extends RecyclerView.ViewHolder {
        TextView tvRoute, tvDate, tvTime;
        Button btnCancel;

        public BookingViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRoute = itemView.findViewById(R.id.tv_route);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvTime = itemView.findViewById(R.id.tv_time);
            btnCancel = itemView.findViewById(R.id.btn_cancel_booking);
        }
    }
}
