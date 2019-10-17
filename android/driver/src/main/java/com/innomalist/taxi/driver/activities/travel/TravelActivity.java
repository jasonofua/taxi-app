package com.innomalist.taxi.driver.activities.travel;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.location.LocationListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.PolyUtil;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.innomalist.taxi.common.components.BaseActivity;
import com.innomalist.taxi.common.components.LoadingDialog;
import com.innomalist.taxi.common.events.ServiceCallRequestEvent;
import com.innomalist.taxi.common.events.ServiceCallRequestResultEvent;
import com.innomalist.taxi.common.events.ServiceCancelEvent;
import com.innomalist.taxi.common.events.ServiceCancelResultEvent;
import com.innomalist.taxi.common.location.MapHelper;
import com.innomalist.taxi.common.utils.AlertDialogBuilder;
import com.innomalist.taxi.common.utils.CommonUtils;
import com.innomalist.taxi.common.utils.DirectionsJSONParser;
import com.innomalist.taxi.common.utils.LocationHelper;
import com.innomalist.taxi.driver.R;
import com.innomalist.taxi.driver.databinding.ActivityTravelBinding;
import com.innomalist.taxi.driver.events.LocationChangedEvent;
import com.innomalist.taxi.driver.events.SendTravelInfoEvent;
import com.innomalist.taxi.driver.events.ServiceFinishEvent;
import com.innomalist.taxi.driver.events.ServiceFinishResultEvent;
import com.innomalist.taxi.driver.events.ServiceInLocationEvent;
import com.innomalist.taxi.driver.events.ServiceStartEvent;
import com.transitionseverywhere.TransitionManager;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TravelActivity extends BaseActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    float distance = 0;
    boolean waiting = false;
    int timeGone = 0;
    int timeWait = 0;
    Double cost = 0d;
    Double initialCost = 0d;
    Double everyKm = 0d;
    Double everyMinuteGone = 0d;
    Double EveryMinuteWait = 0d;
    boolean endTravel = false;
    double lastLat;
    double lastLng;
    ActivityTravelBinding binding;
    Marker currentMarker;
    Marker destinationMarker;
    DirectionsJSONParser directionToPassengerRouter;
    List<LatLng> geoLog = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_travel);
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        LocationHelper locationHelper = new LocationHelper(this);
        locationHelper.loadGps(mLocationListener);
        binding.slideStart.setOnSlideCompleteListener(slideView -> startTravel());
        binding.slideFinish.setOnSlideCompleteListener(slideView -> finishTravel());
        binding.slideCancel.setOnSlideCompleteListener(slideView -> eventBus.post(new ServiceCancelEvent()));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        LatLng dLocation = new LatLng(getIntent().getDoubleExtra("driverLat", -1), getIntent().getDoubleExtra("driverLng", -1));
        lastLat = dLocation.latitude;
        lastLng = dLocation.longitude;
        currentMarker = googleMap.addMarker(new MarkerOptions()
                .position(dLocation)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_taxi)));
        destinationMarker = googleMap.addMarker(new MarkerOptions()
                .position(CommonUtils.currentTravel.getPickupPoint())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_dropoff)));

        googleMap.setOnMapLoadedCallback(() -> {
            List<LatLng> locations = new ArrayList<>();
            locations.add(currentMarker.getPosition());
            locations.add(destinationMarker.getPosition());
            MapHelper.centerLatLngsInMap(gMap, locations, true);
            directionToPassengerRouter = new DirectionsJSONParser(gMap, currentMarker.getPosition(), destinationMarker.getPosition());
            directionToPassengerRouter.run();
        });
    }

    private String computeTime(int time) {
        if (time == 0)
            return "00:00";
        int sec = time % 60;
        int min = time / 60;
        return String.format(Locale.getDefault(), "%02d:%02d", min, sec);
    }

    private Double calculateCost() {
        if (getResources().getBoolean(R.bool.use_fixed_fee)) {
            cost = CommonUtils.bestCost;
            return cost;
        }
        Double costDistance = (distance / 1000) * everyKm;
        Double costTimeGone = (timeGone / 60) * everyMinuteGone;
        Double costTimeWait = (timeWait / 60) * EveryMinuteWait;
        cost = (initialCost + costDistance + costTimeGone + costTimeWait);
        if (cost > 0)
            return cost;
        else
            return 0d;
    }


    private void Timer() {
        Thread th = new Thread(() -> {
            while (!endTravel) {
                runOnUiThread(() -> {
                    if (waiting)
                        timeWait++;
                    else
                        timeGone++;
                    Double cost = calculateCost();
                    binding.distanceText.setText(getString(R.string.unit_distance, (distance / 1000)));
                    binding.timeText.setText(computeTime(timeGone + timeWait));
                    binding.costText.setText(getString(R.string.unit_money, cost));
                    CommonUtils.currentTravel.setDistanceReal((int) distance);
                    CommonUtils.currentTravel.setDurationReal(timeGone + timeWait);
                    CommonUtils.currentTravel.setCost(cost);
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        th.start();
    }


    private final LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(final Location location) {
            distance += LocationHelper.distFrom(lastLat, lastLng, location.getLatitude(), location.getLongitude());
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            eventBus.post(new LocationChangedEvent(latLng));
            eventBus.post(new SendTravelInfoEvent());
            geoLog.add(new LatLng(location.getLatitude(), location.getLongitude()));
            lastLat = location.getLatitude();
            lastLng = location.getLongitude();
            currentMarker.setPosition(new LatLng(lastLat, lastLng));
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(currentMarker.getPosition(), gMap.getCameraPosition().zoom);
            gMap.animateCamera(cameraUpdate);

        }

        @Override
        public void onProviderDisabled(String provider) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }
    };

    void startTravel() {
        eventBus.post(new ServiceStartEvent());
        TransitionManager.beginDelayedTransition((ViewGroup) (binding.getRoot()));
        binding.slideFinish.setVisibility(View.VISIBLE);
        binding.slideCancel.setVisibility(View.GONE);
        binding.slideStart.setVisibility(View.GONE);
        TransitionManager.beginDelayedTransition(binding.layoutActions);
        binding.inLocationButton.setVisibility(View.GONE);
        binding.callButton.setVisibility(View.GONE);
        destinationMarker.setPosition(CommonUtils.currentTravel.getDestinationPoint());
        List<LatLng> locations = new ArrayList<>();
        locations.add(currentMarker.getPosition());
        locations.add(destinationMarker.getPosition());
        MapHelper.centerLatLngsInMap(gMap, locations, true);
        if(directionToPassengerRouter != null)
            directionToPassengerRouter.removeLine();
        Timer();
        DirectionsJSONParser directionsJSONParser = new DirectionsJSONParser(gMap, currentMarker.getPosition(), destinationMarker.getPosition());
        directionsJSONParser.run();
    }

    void finishTravel(){
        endTravel = true;
        String encodedPoly = "";
        if (geoLog.size() > 0)
            encodedPoly = PolyUtil.encode(PolyUtil.simplify(geoLog, 10));
        eventBus.post(new ServiceFinishEvent(cost, timeWait + timeGone, Math.round(distance), encodedPoly));
        //LoadingDialog.show(TravelActivity.this, getString(R.string.service_finishing));
    }
    public void onInLocationButtonClicked(View v) {
        eventBus.post(new ServiceInLocationEvent());
        TransitionManager.beginDelayedTransition(binding.layoutActions);
        binding.inLocationButton.setVisibility(View.GONE);

    }

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

    PermissionListener callPermissionListener = new PermissionListener() {
        @SuppressLint("MissingPermission")
        @Override
        public void onPermissionGranted() {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:+" + CommonUtils.rider.getMobileNumber()));
            startActivity(intent);
        }

        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {

        }
    };

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
    public void onServicedFinished(ServiceFinishResultEvent event) {
        //LoadingDialog.dismiss();
        if (event.hasError()) {
            event.showError(TravelActivity.this, result -> {
                if (result == AlertDialogBuilder.DialogResult.RETRY)
                    finishTravel();
            });
            return;
        }
        if (event.isCreditUsed) {
            new MaterialDialog.Builder(this)
                    .title(R.string.message_default_title)
                    .content(R.string.service_finished_credit)
                    .positiveText(R.string.alert_ok)
                    .onPositive((dialog, which) -> finish())
                    .show();
        } else {
            new MaterialDialog.Builder(this)
                    .title(R.string.message_default_title)
                    .content(R.string.service_finished_cash)
                    .positiveText(R.string.alert_ok)
                    .onPositive((dialog, which) -> finish())
                    .show();
        }
    }


    public void onCallDriverClicked(View view) {
        boolean isCallRequestEnabled = getResources().getBoolean(R.bool.is_call_request_enabled_driver);
        boolean isDirectCallEnabled = getResources().getBoolean(R.bool.is_direct_call_enabled_driver);
        if (isCallRequestEnabled && !isDirectCallEnabled)
            eventBus.post(new ServiceCallRequestEvent());
        if (!isCallRequestEnabled && isDirectCallEnabled)
            TedPermission.with(this)
                    .setPermissionListener(callPermissionListener)
                    .setDeniedMessage(R.string.message_permission_denied)
                    .setPermissions(Manifest.permission.CALL_PHONE)
                    .check();
        new MaterialDialog.Builder(this)
                .title(R.string.select_contact_approach)
                .items(new String[]{getString(R.string.direct_call), getString(R.string.operator_call)})
                .itemsCallback((dialog, view1, which, text) -> {
                    if (which == 0)
                        TedPermission.with(TravelActivity.this)
                                .setPermissionListener(callPermissionListener)
                                .setDeniedMessage(R.string.message_permission_denied)
                                .setPermissions(Manifest.permission.CALL_PHONE)
                                .check();
                    if (which == 1)
                        eventBus.post(new ServiceCallRequestEvent());
                })
                .show();
    }
}
