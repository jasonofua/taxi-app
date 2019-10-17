package com.innomalist.taxi.rider.events;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.innomalist.taxi.common.events.BaseResultEvent;
import com.innomalist.taxi.common.models.ServiceCategory;
import com.innomalist.taxi.common.utils.ServerResponse;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CalculateFareResultEvent extends BaseResultEvent {
    public ArrayList<ServiceCategory> serviceCategories;
    public CalculateFareResultEvent() {
        super(ServerResponse.REQUEST_TIMEOUT);
    }
    public CalculateFareResultEvent(int code, JSONArray serviceCategories) {
        super(code);
        Type type = new TypeToken<List<ServiceCategory>>() {}.getType();
        this.serviceCategories = new Gson().fromJson(serviceCategories.toString(), type);
    }
    public CalculateFareResultEvent(int code, String error) {
        super(code,error);
    }
}
