package com.innomalist.taxi.rider.activities.travel;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.innomalist.taxi.common.activities.chargeAccount.ChargeAccountActivity;
import com.innomalist.taxi.common.components.BaseActivity;
import com.innomalist.taxi.common.components.LoadingDialog;
import com.innomalist.taxi.common.events.ServiceCallRequestEvent;
import com.innomalist.taxi.common.events.ServiceCallRequestResultEvent;
import com.innomalist.taxi.common.events.ServiceCancelEvent;
import com.innomalist.taxi.common.events.ServiceCancelResultEvent;
import com.innomalist.taxi.common.location.MapHelper;
import com.innomalist.taxi.common.models.Review;
import com.innomalist.taxi.common.utils.AlertDialogBuilder;
import com.innomalist.taxi.common.utils.AlerterHelper;
import com.innomalist.taxi.common.utils.CommonUtils;
import com.innomalist.taxi.common.utils.ServerResponse;
import com.innomalist.taxi.rider.R;
import com.innomalist.taxi.rider.activities.travel.fragments.DriverInfoDialog;
import com.innomalist.taxi.rider.activities.travel.fragments.ReviewDialog;
import com.innomalist.taxi.rider.databinding.ActivityTravelBinding;
import com.innomalist.taxi.rider.events.AcceptDriverResultEvent;
import com.innomalist.taxi.rider.events.GetTravelInfoResultEvent;
import com.innomalist.taxi.rider.events.ReviewDriverEvent;
import com.innomalist.taxi.rider.events.ReviewDriverResultEvent;
import com.innomalist.taxi.rider.events.ServiceFinishedEvent;
import com.innomalist.taxi.rider.events.ServiceStartedEvent;
import com.transitionseverywhere.TransitionManager;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TravelActivity extends BaseActivity implements OnMapReadyCallback,ReviewDialog.onReviewFragmentInteractionListener {
    ActivityTravelBinding binding;
    Marker currentMarker;
    Marker destinationMarker;
    LatLng startPoint;
    LatLng destinationPoint;
    LatLng driverLocation;
    GoogleMap gMap;
    boolean travelStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_travel);
        if (getString(R.string.stripe_publishable_key).equals("")) {
            binding.balanceLabel.setVisibility(View.INVISIBLE);
            binding.balanceText.setVisibility(View.INVISIBLE);
            binding.chargeAccountButton.setVisibility(View.INVISIBLE);
        }
        binding.slideCancel.setOnSlideCompleteListener(slideView -> eventBus.post(new ServiceCancelEvent()));
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        LoadingDialog.show(TravelActivity.this, getString(R.string.message_loading_travels));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onServiceFinished(ServiceFinishedEvent event) {
        String message;
        if (event.isCreditUsed)
            message = getString(R.string.travel_finished_taken_from_balance, event.amount);
        else
            message = getString(R.string.travel_finished_not_sufficient_balance, event.amount);
        new MaterialDialog.Builder(this)
                .title(R.string.message_default_title)
                .content(message)
                .positiveText(R.string.alert_ok)
                .onPositive((dialog, which) -> finish())
                .show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onServiceCanceled(ServiceCancelResultEvent event) {
        if (event.hasError()) {
            event.showError(TravelActivity.this, result -> {
                if (result == AlertDialogBuilder.DialogResult.RETRY)
                    eventBus.post(new ServiceCancelEvent());
            });
            return;
        }
        AlertDialogBuilder.show(TravelActivity.this, getString(R.string.service_canceled), AlertDialogBuilder.DialogButton.OK, result -> finish());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReviewResult(ReviewDriverResultEvent event) {
        if (event.response == ServerResponse.OK) {
            AlerterHelper.showInfo(TravelActivity.this,getString(R.string.message_review_sent));
            binding.reviewButton.setEnabled(false);
        } else
            event.showAlert(TravelActivity.this);
    }

    public void onChargeAccountClicked(View view) {
        Intent intent = new Intent(TravelActivity.this, ChargeAccountActivity.class);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onInitializeTravel(AcceptDriverResultEvent event) {
        startPoint = event.startPoint;
        destinationPoint = event.destinationPoint;
        LoadingDialog.dismiss();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTravelStarted(ServiceStartedEvent event) {
        travelStarted = true;
        AlerterHelper.showInfo(TravelActivity.this,getString(R.string.message_travel_started));
        updateMarkers();
        TransitionManager.beginDelayedTransition((ViewGroup) (binding.getRoot()));
        binding.callButton.setVisibility(View.GONE);
        binding.slideCancel.setVisibility(View.GONE);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTravelInfoReceived(GetTravelInfoResultEvent event) {
        driverLocation = event.location;
        binding.timeText.setText(String.format(Locale.getDefault(),"%02d:%02d", event.time / 60, event.time % 60));
        binding.distanceText.setText(getString(R.string.unit_distance, (float) event.distance / 1000));
        binding.costText.setText(getString(R.string.unit_money, event.cost));
        updateMarkers();
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        gMap = googleMap;

    }

    void updateMarkers() {
        LatLng currentMarkerPosition;
        LatLng destinationMarkerPosition;
        List<LatLng> locations = new ArrayList<>();
        if (!travelStarted) {
            currentMarkerPosition = driverLocation;
            destinationMarkerPosition = startPoint;

        } else {
            currentMarkerPosition = driverLocation;
            destinationMarkerPosition = destinationPoint;
        }
        if (currentMarker == null)
            currentMarker = gMap.addMarker(new MarkerOptions()
                    .position(currentMarkerPosition)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_taxi)));
        if (destinationMarker == null)
            destinationMarker = gMap.addMarker(new MarkerOptions()
                    .position(destinationMarkerPosition)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_dropoff)));
        else {
            currentMarker.setPosition(currentMarkerPosition);
            destinationMarker.setPosition(destinationMarkerPosition);
        }
        locations.add(currentMarker.getPosition());
        locations.add(destinationMarker.getPosition());
        MapHelper.centerLatLngsInMap(gMap, locations, true);

    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.balanceText.setText(getString(R.string.unit_money, CommonUtils.rider.getBalance()));
    }

    PermissionListener callPermissionListener = new PermissionListener() {
        @SuppressLint("MissingPermission")
        @Override
        public void onPermissionGranted() {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:+" + CommonUtils.driver.getMobileNumber()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {

        }
    };


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCallRequested(ServiceCallRequestResultEvent event) {
        LoadingDialog.dismiss();
        if (event.hasError()) {
            event.showError(TravelActivity.this, result -> {
                if (result == AlertDialogBuilder.DialogResult.RETRY)
                    onCallDriverClicked(null);
            });
            return;
        }
        AlertDialogBuilder.show(TravelActivity.this, getString(R.string.call_request_sent));
    }

    @Override
    public void onReviewTravelClicked(Review review) {
        eventBus.post(new ReviewDriverEvent(review));
    }

    public void onDriverInfoClicked(View view) {
        FragmentManager fm = getSupportFragmentManager();
        DriverInfoDialog driverInfoDialog = DriverInfoDialog.newInstance(CommonUtils.driver);
        driverInfoDialog.show(fm, "fragment_driver_info");
    }

    public void onReviewTravelClicked(View view) {
        FragmentManager fm = getSupportFragmentManager();
        ReviewDialog reviewDialog = ReviewDialog.newInstance();
        reviewDialog.show(fm, "fragment_review_travel");
    }

    public void onCallDriverClicked(View view) {
        boolean isCallRequestEnabled = getResources().getBoolean(R.bool.is_call_request_enabled_rider);
        boolean isDirectCallEnabled = getResources().getBoolean(R.bool.is_direct_call_enabled_rider);
        if (isCallRequestEnabled && !isDirectCallEnabled)
            eventBus.post(new ServiceCallRequestEvent());
        if(!isCallRequestEnabled && isDirectCallEnabled)
            TedPermission.with(this)
                    .setPermissionListener(callPermissionListener)
                    .setDeniedMessage(R.string.message_permission_denied)
                    .setPermissions(Manifest.permission.CALL_PHONE)
                    .check();
        new MaterialDialog.Builder(this)
                .title(R.string.select_contact_approach)
                .items(new String[]{getString(R.string.direct_call),getString(R.string.operator_call)})
                .itemsCallback((dialog, view1, which, text) -> {
                    if(which == 0)
                        TedPermission.with(TravelActivity.this)
                                .setPermissionListener(callPermissionListener)
                                .setDeniedMessage(R.string.message_permission_denied)
                                .setPermissions(Manifest.permission.CALL_PHONE)
                                .check();
                    if(which == 1)
                        eventBus.post(new ServiceCallRequestEvent());
                })
                .show();
    }
}
