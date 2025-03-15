package com.example.transportmuhiarov;

public class Route {
    private String from;
    private String to;
    private String departureTime;
    private String arrivalTime;
    private String transportType;

    public Route(String from, String to, String departureTime, String arrivalTime, String transportType) {
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.transportType = transportType;
    }

    public String getFrom() { return from; }
    public String getTo() { return to; }
    public String getDepartureTime() { return departureTime; }
    public String getArrivalTime() { return arrivalTime; }
    public String getTransportType() { return transportType; }
}
