package com.innomalist.taxi.common.utils;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;

import com.innomalist.taxi.common.components.LoadingDialog;

public class TimeOut {

    public static void removeTimer(long id) {
        for (TimeOut timer : CommonUtils.timerList) {

            if (timer.getId() == id) {
                timer.stopTime();
                CommonUtils.timerList.remove(timer);
            }

        }
    }

    CountDownTimer time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;

    public TimeOut(long id) {
        this.id = id;
    }

    public void timeOut(final Context context, final String action) {
        time = new CountDownTimer(CommonUtils.timeOut, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                try {
                    //if (Calendar.getInstance().getTimeInMillis() <= id) return;
                    Intent i = new Intent();
                    i.setAction(action);
                    i.putExtra("message", "");
                    i.putExtra("type", ServerResponse.REQUEST_TIMEOUT);
                    context.sendBroadcast(i);
                    LoadingDialog.dismiss();
                } catch (Exception x) {
                }
            }
        }.start();
    }

    public void stopTime() {

        time.cancel();
    }
}

