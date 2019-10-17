package com.innomalist.taxi.common.events;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.innomalist.taxi.common.R;
import com.innomalist.taxi.common.interfaces.AlertDialogEvent;
import com.innomalist.taxi.common.utils.AlertDialogBuilder;
import com.innomalist.taxi.common.utils.AlerterHelper;
import com.innomalist.taxi.common.utils.CommonUtils;
import com.innomalist.taxi.common.utils.ServerResponse;


public class BaseResultEvent {
    public ServerResponse response;
    public String message;

    public BaseResultEvent(int code) {
        this.response = ServerResponse.get(code);
        if (CommonUtils.currentTimer != null)
            CommonUtils.currentTimer.cancel();
    }

    public BaseResultEvent(ServerResponse response) {
        this.response = response;
        if (CommonUtils.currentTimer != null)
            CommonUtils.currentTimer.cancel();
    }

    public BaseResultEvent(int code, String message) {
        this.response = ServerResponse.get(code);
        this.message = message;
        if (CommonUtils.currentTimer != null)
            CommonUtils.currentTimer.cancel();
    }

    public boolean hasError() {
        return response.getValue() != 200;
    }

    public String getErrorMessage(Context context) {
        if (message != null && !message.equals(""))
            return message;
        else {
            String message = response.name();
            int testExists = context.getResources().getIdentifier("error_" + String.valueOf(response.getValue()), "string", context.getPackageName());
            if (testExists > 0)
                message = context.getString(testExists);
            return message;
        }
    }

    public void showError(Context context, AlertDialogEvent alertDialogEvent) {
        AlertDialogBuilder.show(context, getErrorMessage(context), AlertDialogBuilder.DialogButton.CANCEL_RETRY, alertDialogEvent);
    }

    public void showAlert(Context context) {
        AlerterHelper.showError(context, getErrorMessage(context));
    }
}
