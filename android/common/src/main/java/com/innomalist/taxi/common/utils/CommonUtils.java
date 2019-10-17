package com.innomalist.taxi.common.utils;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.model.LatLng;
import com.innomalist.taxi.common.R;
import com.innomalist.taxi.common.interfaces.AlertDialogEvent;
import com.innomalist.taxi.common.models.Driver;
import com.innomalist.taxi.common.models.DriverType;
import com.innomalist.taxi.common.models.Media;
import com.innomalist.taxi.common.models.Request;
import com.innomalist.taxi.common.models.Rider;
import com.innomalist.taxi.common.models.Travel;
import com.innomalist.taxi.common.models.TravelType;

import java.util.ArrayList;
import java.util.List;

public class CommonUtils {
    public static ArrayList<TimeOut> timerList = new ArrayList<>();
    public static Driver driver;
    public static Rider rider;
    public static Travel currentTravel;
    public static Double bestCost = 0d;
    public static int timeOut = 20000;
    public static ArrayList<Request> requests = new ArrayList<>();
    public static List<DriverType> driverTypes = new ArrayList<>();
    public final static int MY_PERMISSIONS_REQUEST_STORAGE = 2;
    public final static int MY_PERMISSIONS_REQUEST_CONTACTS = 3;
    public static CountDownTimer currentTimer;

    public static void displayPromptForEnablingGPS(final AppCompatActivity activity) {
        final String action = Settings.ACTION_LOCATION_SOURCE_SETTINGS;
        final String message = activity.getString(R.string.prompt_enable_gps);
        LocationManager manager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            AlertDialogBuilder.show(activity, message, AlertDialogBuilder.DialogButton.OK_CANCEL, result -> {
                if (result == AlertDialogBuilder.DialogResult.OK)
                    activity.startActivity(new Intent(action));
            });
        }
    }

    public static boolean isInternetEnabled (AppCompatActivity activity) {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(cm == null)
            return false;
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    public static boolean isGPSEnabled (AppCompatActivity activity){
        LocationManager locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    public static double[] latLngToArray(LatLng latLng) {
        return new double[] {latLng.latitude,latLng.longitude};
    }
}