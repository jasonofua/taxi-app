package com.innomalist.taxi.rider.activities.main;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.arlib.floatingsearchview.FloatingSearchView;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;
import com.google.maps.android.SphericalUtil;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.innomalist.taxi.common.activities.chargeAccount.ChargeAccountActivity;
import com.innomalist.taxi.common.activities.travels.TravelsActivity;
import com.innomalist.taxi.common.components.BaseActivity;
import com.innomalist.taxi.common.events.ProfileInfoChangedEvent;
import com.innomalist.taxi.common.location.MapHelper;
import com.innomalist.taxi.common.models.CRUD;
import com.innomalist.taxi.common.models.DriverLocation;
import com.innomalist.taxi.common.models.Service;
import com.innomalist.taxi.common.models.Travel;
import com.innomalist.taxi.common.utils.AlertDialogBuilder;
import com.innomalist.taxi.common.utils.AlerterHelper;
import com.innomalist.taxi.common.utils.CommonUtils;
import com.innomalist.taxi.common.utils.DataBinder;
import com.innomalist.taxi.common.utils.LocationHelper;
import com.innomalist.taxi.common.utils.MyPreferenceManager;
import com.innomalist.taxi.common.utils.ServerResponse;
import com.innomalist.taxi.rider.R;
import com.innomalist.taxi.rider.activities.about.AboutActivity;
import com.innomalist.taxi.rider.activities.addresses.AddressesActivity;
import com.innomalist.taxi.rider.activities.main.adapters.ServiceCategoryViewPagerAdapter;
import com.innomalist.taxi.rider.activities.main.dialogs.DriverAcceptedDialog;
import com.innomalist.taxi.rider.activities.main.fragments.ServiceCarousalFragment;
import com.innomalist.taxi.rider.activities.profile.ProfileActivity;
import com.innomalist.taxi.rider.databinding.ActivityMainBinding;
import com.innomalist.taxi.rider.events.CRUDAddressRequestEvent;
import com.innomalist.taxi.rider.events.CRUDAddressResultEvent;
import com.innomalist.taxi.rider.events.CalculateFareRequestEvent;
import com.innomalist.taxi.rider.events.CalculateFareResultEvent;
import com.innomalist.taxi.rider.events.GetDriversLocationEvent;
import com.innomalist.taxi.rider.events.GetDriversLocationResultEvent;
import com.innomalist.taxi.rider.events.ServiceRequestErrorEvent;
import com.innomalist.taxi.rider.ui.trail.RouteOverlayView;
import com.innomalist.taxi.rider.ui.trail.TrailSupportMapFragment;
import com.transitionseverywhere.Fade;
import com.transitionseverywhere.Slide;
import com.transitionseverywhere.TransitionManager;
import com.transitionseverywhere.TransitionSet;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends BaseActivity implements OnMapReadyCallback, ServiceCarousalFragment.OnServicesCarousalFragmentListener {

    ActivityMainBinding binding;
    MyPreferenceManager SP;
    GoogleMap mMap;
    Marker pickupPoint;
    public LatLng pickupLatLng;
    public LatLng destinationLatLng;
    public String pickupAddress;
    public String destinationAddress;
    MarkerMode markerMode = MarkerMode.origin;
    DriverAcceptedDialog driverAcceptedDialog;
    ArrayList<Marker> driverMarkers;
    private static final int ACTIVITY_PROFILE = 11;
    private static final int ACTIVITY_CHARGE = 12;
    private static final int ACTIVITY_PLACES = 13;
    private static final int ACTIVITY_TRAVEL = 14;
    private static final int ACTIVITY_VOICE_RECOGNITION = 15;
    BottomSheetBehavior bottomSheetBehavior;
    LatLng currentLocation;
    public Service selectedService;

    @Override
    public void onServiceSelected(Service service) {
        selectedService = service;
        binding.buttonRequest.setEnabled(true);
        binding.buttonRequest.setText(getString(R.string.confirm_service, service.getTitle()));
    }

    private enum MarkerMode {
        origin,
        destination,
        serviceSelection
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.setImmersive(true);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        currentLocation = LocationHelper.DoubleArrayToLatLng(getIntent().getDoubleArrayExtra("currentLocation"));
        binding.buttonConfirmPickup.setEnabled(false);
        binding.buttonConfirmPickup.setOnClickListener(view -> onButtonConfirmPickupClicked());
        binding.buttonConfirmDestination.setOnClickListener(view -> onButtonConfirmDestinationClicked());
        binding.buttonRequest.setOnClickListener(view -> onButtonConfirmServiceClicked());
        bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        binding.searchText.setSelected(true);
        binding.drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                binding.searchPlace.closeMenu(true);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        binding.searchPlace.setOnLeftMenuClickListener(new FloatingSearchView.OnLeftMenuClickListener() {
            @Override
            public void onMenuOpened() {
                if (markerMode == MarkerMode.origin)
                    binding.drawerLayout.openDrawer(Gravity.START);
            }

            @Override
            public void onMenuClosed() {
                if (markerMode == MarkerMode.serviceSelection) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
                if (markerMode == MarkerMode.destination || markerMode == MarkerMode.serviceSelection) {
                    TransitionManager.beginDelayedTransition((ViewGroup) binding.getRoot(), (new TransitionSet()).addTransition(new Slide()).addTransition(new Fade()));
                    binding.buttonConfirmDestination.setVisibility(View.GONE);
                    binding.buttonConfirmPickup.setVisibility(View.VISIBLE);
                    markerMode = MarkerMode.origin;
                    mMap.animateCamera(CameraUpdateFactory.newLatLng(pickupPoint.getPosition()));
                    pickupPoint.remove();
                }
            }
        });
        binding.searchPlace.setOnFocusChangeListener(new FloatingSearchView.OnFocusChangeListener() {
            @Override
            public void onFocus() {
                findPlace("");
            }

            @Override
            public void onFocusCleared() {

            }
        });
        binding.searchPlace.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case (R.id.action_favorites):
                    eventBus.post(new CRUDAddressRequestEvent(CRUD.READ));
                    break;
                case (R.id.action_voice_rec):
                    displaySpeechRecognizer();
                    break;
                case (R.id.action_location):
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 16f));
                    break;
            }
        });
        driverMarkers = new ArrayList<>();
        CommonUtils.currentTravel = new Travel();
        SP = MyPreferenceManager.getInstance(getApplicationContext());
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //setSupportActionBar(binding.mainToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.menu);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getString(R.string.app_name));
        }
        if (binding.navigationView != null) {
            if (getString(R.string.stripe_publishable_key).equals(""))
                binding.navigationView.getMenu().findItem(R.id.nav_item_charge_account).setVisible(false);
            binding.navigationView.setNavigationItemSelectedListener(menuItem -> {
                binding.drawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case (R.id.nav_item_favorites):
                        Intent intent = new Intent(MainActivity.this, AddressesActivity.class);
                        double[] array = LocationHelper.LatLngToDoubleArray(currentLocation);
                        intent.putExtra("currentLocation",array);
                        startActivity(intent);
                        break;
                    case (R.id.nav_item_travels):
                        startActivity(new Intent(MainActivity.this, TravelsActivity.class));
                        break;
                    case (R.id.nav_item_profile):
                        startActivityForResult(new Intent(MainActivity.this, ProfileActivity.class), ACTIVITY_PROFILE);
                        break;
                    case (R.id.nav_item_charge_account):
                        startActivity(new Intent(MainActivity.this, ChargeAccountActivity.class));
                        break;
                    case (R.id.nav_item_about):
                        startActivity(new Intent(MainActivity.this, AboutActivity.class));
                        break;
                    case (R.id.nav_item_exit):
                        logout();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            });
        }
        fillInfo();
    }

    private void logout() {
        SP.putString("rider_token", "");
        finish();
    }

    private void showCurvedPolyline (LatLng p1, LatLng p2, double k) {
        //Calculate distance and heading between two points
        double d = SphericalUtil.computeDistanceBetween(p1,p2);
        double h = SphericalUtil.computeHeading(p1, p2);

        //Midpoint position
        LatLng p = SphericalUtil.computeOffset(p1, d*0.5, h);

        //Apply some mathematics to calculate position of the circle center
        double x = (1-k*k)*d*0.5/(2*k);
        double r = (1+k*k)*d*0.5/(2*k);

        LatLng c = SphericalUtil.computeOffset(p, x, h + 90.0);

        //Polyline options
        PolylineOptions options = new PolylineOptions();
        List<PatternItem> pattern = Arrays.asList(new Dash(30), new Gap(20));

        //Calculate heading between circle center and two points
        double h1 = SphericalUtil.computeHeading(c, p1);
        double h2 = SphericalUtil.computeHeading(c, p2);

        //Calculate positions of points on circle border and add them to polyline options
        int numpoints = 100;
        double step = (h2 -h1) / numpoints;

        for (int i=0; i < numpoints; i++) {
            LatLng pi = SphericalUtil.computeOffset(c, r, h1 + i * step);
            options.add(pi);
        }

        //Draw polyline
        mMap.addPolyline(options.width(10).color(getPrimaryColor()).geodesic(false).pattern(pattern));
    }

    public void findPlace(String preText) {
        try {
            AutocompleteFilter autocompleteFilter = (new AutocompleteFilter.Builder()).setTypeFilter(AutocompleteFilter.TYPE_FILTER_ADDRESS).build();
            Intent intent =
                    new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .setFilter(autocompleteFilter)
                            .build(this);
            if (!TextUtils.isEmpty(preText)) {
                intent.putExtra("initial_query", preText);
            }
            startActivityForResult(intent, ACTIVITY_PLACES);
        } catch (GooglePlayServicesRepairableException e) {
            // TODO: Handle the error.
        } catch (GooglePlayServicesNotAvailableException e) {
            // TODO: Handle the error.
        }
    }

    // Create an intent that can start the Speech Recognizer activity
    private void displaySpeechRecognizer() {
        TedPermission.with(this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage(getString(R.string.message_permission_denied))
                .setPermissions(Manifest.permission.RECORD_AUDIO)
                .check();
    }

    PermissionListener permissionlistener = new PermissionListener() {
        @Override
        public void onPermissionGranted() {
            try {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                MainActivity.this.startActivityForResult(intent, ACTIVITY_VOICE_RECOGNITION);
            } catch (ActivityNotFoundException e) {
                AlertDialogBuilder.show(MainActivity.this, getString(R.string.question_install_speech), getString(R.string.error), AlertDialogBuilder.DialogButton.OK_CANCEL, result -> {
                    if(result == AlertDialogBuilder.DialogResult.OK){
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://market.android.com/details?id=com.google.android.voicesearch"));
                        startActivity(browserIntent);
                    }
                });

            }
        }

        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {

        }
    };

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAddressesReceived(CRUDAddressResultEvent event) {
        if (event.crud != CRUD.READ || !isInForeground)
            return;
        List<String> addressStrings = new ArrayList<>();
        for (com.innomalist.taxi.common.models.Address address :
                event.addresses) {
            addressStrings.add(address.getTitle());
        }
        new MaterialDialog.Builder(this)
                .title(R.string.drawer_favorite_locations)
                .items(addressStrings)
                .itemsCallback((dialog, view, which, text) -> {
                    if (event.addresses.get(which).getLocation() != null) {
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(event.addresses.get(which).getLocation()));
                    }
                    binding.searchText.setText(event.addresses.get(which).getAddress());

                })
                .show();
    }

    private void onButtonConfirmPickupClicked() {
        binding.buttonConfirmDestination.setEnabled(false);
        TransitionManager.beginDelayedTransition((ViewGroup) binding.getRoot(), (new TransitionSet()).addTransition(new Slide()).addTransition(new Fade()));
        binding.buttonConfirmPickup.setVisibility(View.GONE);
        binding.buttonConfirmDestination.setVisibility(View.VISIBLE);
        markerMode = MarkerMode.destination;
        binding.searchPlace.openMenu(true);
        pickupLatLng = mMap.getCameraPosition().target;
        pickupPoint = mMap.addMarker(new MarkerOptions()
                .position(pickupLatLng)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_pickup)));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(mMap.getCameraPosition().target.latitude + 0.001, mMap.getCameraPosition().target.longitude)));
    }

    private void onButtonConfirmDestinationClicked() {
        binding.buttonRequest.setEnabled(false);
        markerMode = MarkerMode.serviceSelection;
        binding.imageMarker.setVisibility(View.GONE);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        destinationLatLng = mMap.getCameraPosition().target;
        mMap.setPadding(0, binding.bottomSheet.getHeight() / 10, 0, binding.bottomSheet.getHeight());
        List<LatLng> latLngs = new ArrayList<>();
        latLngs.add(pickupLatLng);
        latLngs.add(destinationLatLng);
        pickupPoint.remove();
        MapHelper.centerLatLngsInMap(mMap, latLngs, true);
        mMap.getUiSettings().setAllGesturesEnabled(false);
        binding.mapLayout.postDelayed(() -> {
            ((TrailSupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).setUpPath(latLngs, mMap, RouteOverlayView.AnimType.ARC);
            //showCurvedPolyline(pickupLatLng,destinationLatLng,1);
            //Polyline polyline1 = mMap.addPolyline(new PolylineOptions().clickable(true).add(pickupLatLng,destinationLatLng).color(getPrimaryColor()).endCap(new RoundCap()).startCap(new RoundCap()));
        }, 1500);
        TransitionManager.beginDelayedTransition((ViewGroup) binding.getRoot(), (new TransitionSet()).addTransition(new Fade()));
        binding.buttonConfirmDestination.setVisibility(View.GONE);
        binding.searchPlace.setVisibility(View.GONE);
        eventBus.post(new CalculateFareRequestEvent(pickupLatLng, destinationLatLng));
    }

    private void goBackFromServiceSelection() {
        Intent i = getIntent();
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        markerMode = MarkerMode.origin;
        binding.imageMarker.setVisibility(View.VISIBLE);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        mMap.setPadding(0, 0, 0, 0);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        binding.buttonConfirmPickup.setEnabled(false);
        TransitionManager.beginDelayedTransition((ViewGroup) binding.getRoot(), (new TransitionSet()).addTransition(new Fade()));
        binding.buttonConfirmPickup.setVisibility(View.VISIBLE);
        binding.searchPlace.setVisibility(View.VISIBLE);
        binding.searchPlace.closeMenu(false);
    }

    private void onButtonConfirmServiceClicked() {
        driverAcceptedDialog = new DriverAcceptedDialog();
        driverAcceptedDialog.show(getSupportFragmentManager(), "DialogDriversAccepted");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCalculateFareReceived(CalculateFareResultEvent event) {
        if (event.hasError()) {
            event.showAlert(this);
            return;
        }
        ServiceCategoryViewPagerAdapter serviceCategoryViewPagerAdapter = new ServiceCategoryViewPagerAdapter(getSupportFragmentManager(), event.serviceCategories);
        binding.serviceTypesViewPager.setAdapter(serviceCategoryViewPagerAdapter);
        // Give the TabLayout the ViewPager
        binding.tabCategories.setupWithViewPager(binding.serviceTypesViewPager);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                binding.drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 16.0f));
        mMap.setOnCameraIdleListener(() -> {
            GetMarkerAddress task = new GetMarkerAddress();
            task.execute(googleMap.getCameraPosition().target.latitude, googleMap.getCameraPosition().target.longitude);
            eventBus.post(new GetDriversLocationEvent(googleMap.getCameraPosition().target));

        });
        if (getResources().getBoolean(R.bool.isNightMode)) {
            mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.map_night));
        }
        mMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
            @Override public void onCameraMove() {
                ((TrailSupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).onCameraMove(mMap);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (markerMode == MarkerMode.origin) {
            AlertDialogBuilder.show(MainActivity.this, getString(R.string.message_exit), AlertDialogBuilder.DialogButton.OK_CANCEL, result -> {
                if (result == AlertDialogBuilder.DialogResult.OK)
                    MainActivity.this.finishAffinity();
            });
        }
        if (markerMode == MarkerMode.serviceSelection) {
            goBackFromServiceSelection();
        }
    }

    private void fillInfo() {
        try {
            String name;
            if (CommonUtils.rider.status != null && CommonUtils.rider.status.equals("blocked")) {
                logout();
                return;
            }
            if ((CommonUtils.rider.getFirstName() == null || CommonUtils.rider.getFirstName().isEmpty()) && (CommonUtils.rider.getLastName() == null || CommonUtils.rider.getLastName().isEmpty()))
                name = getString(R.string.drawer_header_unknown);
            else
                name = CommonUtils.rider.getFirstName() + " " + CommonUtils.rider.getLastName();
            View header = binding.navigationView.getHeaderView(0);
            ((TextView) header.findViewById(R.id.navigation_header_name)).setText(name);
            ((TextView) header.findViewById(R.id.navigation_header_charge)).setText(getString(R.string.drawer_header_balance, CommonUtils.rider.getBalance()));
            ImageView imageView = header.findViewById(R.id.navigation_header_image);
            DataBinder.setMedia(imageView, CommonUtils.rider.getMedia());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDriversLocationResult(GetDriversLocationResultEvent event) {
        if (event.response != ServerResponse.OK)
            return;
        for (Marker marker : driverMarkers) {
            marker.remove();
            driverMarkers.remove(marker);
        }
        for (DriverLocation driverLocation : event.driverLocations)
            driverMarkers.add(mMap.addMarker(new MarkerOptions()
                    .position(driverLocation.location)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_taxi))));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRequestTaxiError(ServiceRequestErrorEvent event) {
        if (driverAcceptedDialog != null)
            driverAcceptedDialog.dismiss();
        event.showAlert(MainActivity.this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onProfileChanged(ProfileInfoChangedEvent event) {
        fillInfo();
        //binding.pagerDriverTypes.getAdapter().notifyDataSetChanged();
    }

    /*private void getLastKnownLocation() {
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationManager manager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
        if (manager == null)
            return;
        List<String> providers = manager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            Location l = manager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                bestLocation = l;
            }
        }
        LatLng latLng;
        if (bestLocation == null)
            latLng = new LatLng(Float.parseFloat(getString(R.string.defaultLocation).split(",")[0]), Float.parseFloat(getString(R.string.defaultLocation).split(",")[1]));
        else
            latLng = new LatLng(bestLocation.getLatitude(), bestLocation.getLongitude());
        //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
    }*/

    @SuppressLint("StaticFieldLeak")
    private class GetMarkerAddress extends AsyncTask<Double, Void, String> {
        @Override
        protected String doInBackground(Double... floats) {
            Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
            List<Address> addresses = null;
            try {
                addresses = geocoder.getFromLocation(floats[0], floats[1], 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (addresses != null && addresses.size() > 0) {
                String address = "";
                if (addresses.get(0).getThoroughfare() != null)
                    address = addresses.get(0).getThoroughfare();
                if (addresses.get(0).getFeatureName() != null) {
                    if (address.equals(""))
                        address = addresses.get(0).getFeatureName();
                    else
                        address += ", " + addresses.get(0).getFeatureName();
                }
                return address;
            } else
                return getString(R.string.unknown_location);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            binding.searchText.setText(s);
            if (markerMode == MarkerMode.origin) {
                pickupAddress = s;
                binding.buttonConfirmPickup.setEnabled(true);
            } else {
                destinationAddress = s;
                binding.buttonConfirmDestination.setEnabled(true);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (ACTIVITY_PROFILE):
                if (resultCode == RESULT_OK)
                    AlerterHelper.showInfo(MainActivity.this, getString(R.string.info_edit_profile_success));
                fillInfo();
                break;
            case (ACTIVITY_CHARGE):
                if (resultCode == RESULT_OK)
                    AlerterHelper.showInfo(MainActivity.this, getString(R.string.account_charge_success));
            case (ACTIVITY_PLACES):
                binding.searchPlace.clearSearchFocus();
                if (resultCode == RESULT_OK) {
                    Place place = PlaceAutocomplete.getPlace(this, data);
                    mMap.animateCamera(CameraUpdateFactory.newLatLng(place.getLatLng()));
                }
                break;
            case (ACTIVITY_VOICE_RECOGNITION):
                if (resultCode == RESULT_OK) {
                    List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    if (results.size() > 0)
                        findPlace(results.get(0));
                    else
                        AlerterHelper.showWarning(this, getString(R.string.warning_voice_recognizer_failed));
                }
                break;

            case (ACTIVITY_TRAVEL):
                goBackFromServiceSelection();
                break;
        }
    }
}
