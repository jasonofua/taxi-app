package com.innomalist.taxi.common.events;

public class ChargeAccountResultEvent extends BaseResultEvent {
    public String errorMessage;
    public ChargeAccountResultEvent(int code,String errorMessage) {
        super(code);
        this.errorMessage = errorMessage;
    }
}
