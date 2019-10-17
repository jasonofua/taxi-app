package com.innomalist.taxi.common.events;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.innomalist.taxi.common.models.Travel;
import com.innomalist.taxi.common.utils.ServerResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetTravelsResultEvent extends BaseResultEvent {
    public ArrayList<Travel> travels;
    public GetTravelsResultEvent(int response, String travelEntities) {
        super(response);
        if(this.response != ServerResponse.OK)
            return;
        Type type = new TypeToken<List<Travel>>() {
        }.getType();
        this.travels = new Gson().fromJson(travelEntities, type);
    }
}
