package com.innomalist.taxi.rider.activities.main.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.innomalist.taxi.common.models.Driver;
import com.innomalist.taxi.common.models.DriverInfo;
import com.innomalist.taxi.common.utils.CommonUtils;
import com.innomalist.taxi.common.utils.DataBinder;
import com.innomalist.taxi.rider.R;
import com.innomalist.taxi.rider.databinding.CardDriverAcceptedBinding;
import com.innomalist.taxi.rider.databinding.CardDriverInfoBinding;
import com.innomalist.taxi.rider.events.AcceptDriverEvent;
import com.innomalist.taxi.rider.events.AcceptDriverUIEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class DriverAcceptedCardAdapter extends BaseAdapter {

    private List<DriverInfo> mData;
    private LayoutInflater layoutInflater;

    public DriverAcceptedCardAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        this.mData = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    public void addDriver(DriverInfo driver) {
        mData.add(driver);
    }

    @Override
    public DriverInfo getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        /*if (convertView == null)
            convertView = layoutInflater.inflate(R.layout.card_driver_info, parent, false);*/
        final DriverInfo info = mData.get(position);
        final Driver driver = info.driver;

        CardDriverAcceptedBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.card_driver_accepted, parent, false);
        binding.setInfo(info);
        binding.executePendingBindings();
        if (driver.getMedia() != null)
            DataBinder.setMedia(binding.imageDriver,driver.getMedia());
        if (driver.getCarMedia() != null)
            DataBinder.setMedia(binding.imageHeader,driver.getCarMedia());
        if(parent.getContext().getResources().getBoolean(R.bool.auto_select_first_driver)){
            EventBus.getDefault().post(new AcceptDriverEvent(driver.getId()));
            EventBus.getDefault().post(new AcceptDriverUIEvent());
            CommonUtils.driver = driver;
            return binding.getRoot();
        }
        binding.buttonAccept.setTag(driver.getId());
        binding.buttonAccept.setOnClickListener(view -> {
            EventBus.getDefault().post(new AcceptDriverEvent((Integer) view.getTag()));
            EventBus.getDefault().post(new AcceptDriverUIEvent());
            CommonUtils.driver = driver;
        });
        return binding.getRoot();
    }
}
