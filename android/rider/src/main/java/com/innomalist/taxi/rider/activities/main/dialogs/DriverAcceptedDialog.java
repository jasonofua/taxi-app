package com.innomalist.taxi.rider.activities.main.dialogs;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.innomalist.taxi.rider.R;
import com.innomalist.taxi.rider.activities.main.MainActivity;
import com.innomalist.taxi.rider.activities.main.adapters.DriverAcceptedCardAdapter;
import com.innomalist.taxi.rider.databinding.DialogRequestServiceBinding;
import com.innomalist.taxi.rider.events.AcceptDriverUIEvent;
import com.innomalist.taxi.rider.events.NewDriverAcceptedEvent;
import com.innomalist.taxi.rider.events.ServiceRequestEvent;
import com.innomalist.taxi.rider.events.ServiceRequestResultEvent;
import com.innomalist.taxi.rider.activities.travel.TravelActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DriverAcceptedDialog extends AppCompatDialogFragment {
    DialogRequestServiceBinding binding;
    DriverAcceptedCardAdapter driversAdapter;
    EventBus eventBus;
    boolean acceptedDriver = false;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DialogRequestServiceBinding.inflate(inflater,container,false);
        binding.frameLayout.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
        driversAdapter = new DriverAcceptedCardAdapter(getContext());
        binding.swipeStack.setAdapter(driversAdapter);
        return binding.getRoot();
    }
    @Override
    public void onStart() {
        super.onStart();
        eventBus = EventBus.getDefault();
        eventBus.register(this);
        MainActivity parent = ((MainActivity)getActivity());
        eventBus.post(new ServiceRequestEvent(parent.pickupLatLng, parent.destinationLatLng, parent.pickupAddress, parent.destinationAddress, parent.selectedService.getId()));

        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onServiceRequestResult(ServiceRequestResultEvent event) {
        if (event.hasError()) {
            event.showAlert(getContext());
            dismiss();
            return;
        }
        binding.textLoading.setText(getString(R.string.waiting_for_drivers, String.valueOf(event.driversSentTo)));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDriverAccepted(NewDriverAcceptedEvent event) {
        binding.driversAcceptedLoadingAnimation.pauseAnimation();
        binding.driversAcceptedCard.setVisibility(View.GONE);
        try {
            driversAdapter.addDriver(event.info);
            driversAdapter.notifyDataSetChanged();
        } catch (Exception ignored) {
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAcceptDriver(AcceptDriverUIEvent event) {
        dismiss();
        Intent intent = new Intent(getActivity(), TravelActivity.class);
        getActivity().startActivityForResult(intent,14);
    }

    @Override
    public void onStop() {
        eventBus.unregister(this);
        super.onStop();
    }
}
