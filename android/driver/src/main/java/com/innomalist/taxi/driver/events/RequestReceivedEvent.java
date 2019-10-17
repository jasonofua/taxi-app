package com.innomalist.taxi.driver.events;

import com.innomalist.taxi.common.models.Request;
import com.innomalist.taxi.common.models.Travel;
import com.innomalist.taxi.common.utils.CommonUtils;

public class RequestReceivedEvent {
    public Travel travel;

    public RequestReceivedEvent(String travelJson,Integer travelDistance,Integer fromDriver, Double cost) {
        travel = Travel.fromJson(travelJson);
        Request request = new Request(travel,travelDistance,fromDriver,cost);
        CommonUtils.requests.add(request);
    }
}
