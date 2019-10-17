package com.innomalist.taxi.common.activities.travels;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.innomalist.taxi.common.R;
import com.innomalist.taxi.common.activities.travels.adapters.TravelListViewAdapter;
import com.innomalist.taxi.common.components.BaseActivity;
import com.innomalist.taxi.common.components.LoadingDialog;
import com.innomalist.taxi.common.events.GetTravelsEvent;
import com.innomalist.taxi.common.events.GetTravelsResultEvent;
import com.innomalist.taxi.common.events.HideTravelEvent;
import com.innomalist.taxi.common.events.HideTravelResultEvent;
import com.innomalist.taxi.common.events.WriteComplaintEvent;
import com.innomalist.taxi.common.events.WriteComplaintResultEvent;
import com.innomalist.taxi.common.models.Travel;
import com.innomalist.taxi.common.utils.AlertDialogBuilder;
import com.innomalist.taxi.common.utils.AlerterHelper;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class TravelsActivity extends BaseActivity {

    private String subjectText;
    private String contentText;
    private long lastSelectedTravelId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travels);
        //registerForContextMenu(expandableListView);
        initializeToolbar(getString(R.string.title_travel));
        getTravels();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onWriteComplaintResult(WriteComplaintResultEvent event){
        LoadingDialog.dismiss();
        if(event.hasError()){
            event.showError(TravelsActivity.this, result -> {
                if(result == AlertDialogBuilder.DialogResult.RETRY){
                    eventBus.post(new WriteComplaintEvent(lastSelectedTravelId, subjectText, contentText));
                    LoadingDialog.show(TravelsActivity.this,getString(R.string.sending_complaint));
                }
            });
        } else {
            AlerterHelper.showInfo(TravelsActivity.this,getString(R.string.message_complaint_sent));
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHideTravelResult(HideTravelResultEvent event){
        if(event.hasError())
            return;
        AlerterHelper.showInfo(TravelsActivity.this,getString(R.string.info_travel_hidden));
        getTravels();

    }
    private void getTravels() {
        eventBus.post(new GetTravelsEvent());
        LoadingDialog.show(this, getString(R.string.message_loading_travels));
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onTravelsReceived(GetTravelsResultEvent event) {
        LoadingDialog.dismiss();
        if (event.hasError()) {
            event.showError(TravelsActivity.this, result -> {
                if (result == AlertDialogBuilder.DialogResult.RETRY)
                    getTravels();
                else
                    finish();
            });
            return;
        }
        loadList(event.travels);
    }

    private void showWriteComplaintDialog(int travelId){
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(TravelsActivity.this);
        @SuppressLint("InflateParams") final View mView = layoutInflaterAndroid.inflate(R.layout.dialog_write_complaint, null);
        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(TravelsActivity.this);
        alertDialogBuilderUserInput.setView(mView);


        alertDialogBuilderUserInput
                .setCancelable(false)
                .setPositiveButton(R.string.alert_send, (dialogBox, id) -> {
                    subjectText = ((EditText) mView.findViewById(R.id.text_subject)).getText().toString();
                    contentText = ((EditText) mView.findViewById(R.id.text_content)).getText().toString();
                    //lastSelectedTravelId = ((Travel) expandableListView.getAdapter().getItem(info.position)).getId();
                    lastSelectedTravelId = travelId;
                    eventBus.post(new WriteComplaintEvent(lastSelectedTravelId, subjectText, contentText));
                    LoadingDialog.show(TravelsActivity.this,getString(R.string.sending_complaint));
                })

                .setNegativeButton(R.string.alert_cancel, (dialogBox, id) -> dialogBox.cancel());

        AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
        alertDialogAndroid.show();
    }
    private void loadList(final ArrayList<Travel> travels) {
        if (travels == null)
            return;

        final TravelListViewAdapter adapter = new TravelListViewAdapter(TravelsActivity.this,travels);
        adapter.setHideTravelClickListener(view -> eventBus.post(new HideTravelEvent((int)view.getTag())));
        adapter.setWriteComplaintClickListener(view -> showWriteComplaintDialog((int)view.getTag()));
        final ListView listView = findViewById(R.id.list_travels);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((adapterView, view, pos, l) -> {
            // toggle clicked cell state
            //((FoldingCell) view).toggle(false);
            // register in adapter that state for selected cell is toggled
            //adapter.registerToggle(pos);
        });
    }
}