package com.innomalist.taxi.common.models;

import android.os.CountDownTimer;

import java.util.Locale;

public class Request {
    public Travel travel;
    public Double distance;
    public Double fromDriver;
    public Double cost;
    public CountDownTimer timer;

    public Request(Travel travel, Integer distance, Integer fromDriver, Double cost){
        this.travel = travel;
        this.distance = distance.doubleValue() / 1000;
        this.fromDriver = fromDriver.doubleValue() / 1000;
        this.cost = cost;
    }

    private String distanceIntToString(int distance) {
        return String.format(Locale.getDefault(),"%.1f",((float)distance) / 1000);
    }
}
