package com.example.transportmuhiarov;

public class Booking {
    private String from;
    private String to;
    private String departureTime;
    private String arrivalTime;
    private String transportType;

    public Booking(String from, String to, String departureTime, String arrivalTime, String transportType) {
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.transportType = transportType;
    }

    public Booking(String from, String to, String time) {
    }

    public String getFrom() { return from; }
    public String getTo() { return to; }
    public String getDepartureTime() { return departureTime; }
    public String getArrivalTime() { return arrivalTime; }
    public String getTransportType() { return transportType; }

    public String getRoute() {
        return getRoute();
    }

    public String getDate() {
        return getDate();
    }

    public String getTime() {
        return getTime();
    }
}
