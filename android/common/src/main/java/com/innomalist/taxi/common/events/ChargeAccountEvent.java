package com.innomalist.taxi.common.events;

import com.innomalist.taxi.common.utils.ServerResponse;

public class ChargeAccountEvent extends BaseRequestEvent {
    public String stripeToken;
    public float amount;
    public ChargeAccountEvent(String stripeToken,float amount) {
        super(new ChargeAccountResultEvent(ServerResponse.REQUEST_TIMEOUT.getValue(),"TIMEOUT"));
        this.stripeToken = stripeToken;
        this.amount = amount;
    }
}
