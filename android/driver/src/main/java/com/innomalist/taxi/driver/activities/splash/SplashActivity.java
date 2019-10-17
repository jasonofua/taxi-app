package com.innomalist.taxi.driver.activities.splash;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.crashlytics.android.Crashlytics;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.innomalist.taxi.common.utils.LocationHelper;
import com.innomalist.taxi.driver.BuildConfig;
import com.innomalist.taxi.driver.DriverEventBusIndex;
import com.innomalist.taxi.driver.R;
import com.innomalist.taxi.driver.activities.main.MainActivity;
import com.innomalist.taxi.driver.databinding.ActivitySplashBinding;
import com.innomalist.taxi.driver.events.LoginResultEvent;
import com.innomalist.taxi.driver.services.DriverService;
import com.innomalist.taxi.common.components.BaseActivity;
import com.innomalist.taxi.common.events.BackgroundServiceStartedEvent;
import com.innomalist.taxi.common.events.ConnectEvent;
import com.innomalist.taxi.common.events.ConnectResultEvent;
import com.innomalist.taxi.common.events.LoginEvent;
import com.innomalist.taxi.common.interfaces.AlertDialogEvent;
import com.innomalist.taxi.common.models.Driver;
import com.innomalist.taxi.common.utils.AlertDialogBuilder;
import com.innomalist.taxi.common.utils.AlerterHelper;
import com.innomalist.taxi.common.utils.CommonUtils;
import com.innomalist.taxi.common.utils.MyPreferenceManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Collections;

import io.fabric.sdk.android.Fabric;

public class SplashActivity extends BaseActivity {

    MyPreferenceManager SP;
    ActivitySplashBinding binding;
    int RC_SIGN_IN = 123;
    private PermissionListener permissionlistener = new PermissionListener() {
        @Override
        public void onPermissionGranted() {
            try {
                if (!isMyServiceRunning(DriverService.class))
                    startService(new Intent(SplashActivity.this, DriverService.class));
            } catch (Exception c) {
                c.printStackTrace();
            }
        }

        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {

        }
    };
    private View.OnClickListener onLoginClicked = v -> {
        String resourceName = "testMode";
        int testExists = SplashActivity.this.getResources().getIdentifier(resourceName, "string", SplashActivity.this.getPackageName());
        if (testExists > 0) {
            tryLogin(getString(testExists));
            return;
        }
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(
                                Collections.singletonList(new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build()))
                        .setTheme(getCurrentTheme())
                        .build(),
                RC_SIGN_IN);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            EventBus.builder().addIndex(new DriverEventBusIndex()).installDefaultEventBus();
        } catch (Exception ignored) {
        }
        setImmersive(true);
        super.onCreate(savedInstanceState);
        if (!getString(R.string.fabric_key).equals("") && !BuildConfig.DEBUG) {
            Fabric.with(this, new Crashlytics());
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        binding.loginButton.setOnClickListener(onLoginClicked);
        SP = MyPreferenceManager.getInstance(getApplicationContext());

        checkPermissions();

    }

    private void checkPermissions() {
        if (!CommonUtils.isGPSEnabled(this)) {
            AlertDialogBuilder.show(this, "Please enable GPS before proceeding.", AlertDialogBuilder.DialogButton.CANCEL_RETRY, new AlertDialogEvent() {
                @Override
                public void onAnswerDialog(AlertDialogBuilder.DialogResult result) {
                    if (result == AlertDialogBuilder.DialogResult.RETRY) {
                        checkPermissions();
                    } else {
                        finishAffinity();
                    }
                }
            });
            return;
        }
        if (!CommonUtils.isInternetEnabled(this)) {
            AlertDialogBuilder.show(this, "Please enable Data or WiFi as an internet connection", AlertDialogBuilder.DialogButton.CANCEL_RETRY, new AlertDialogEvent() {
                @Override
                public void onAnswerDialog(AlertDialogBuilder.DialogResult result) {
                    if (result == AlertDialogBuilder.DialogResult.RETRY) {
                        checkPermissions();
                    } else {
                        finishAffinity();
                    }
                }
            });
            return;
        }
        TedPermission.with(this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage(getString(R.string.message_permission_denied))
                .setPermissions(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
                .check();
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        try {
            ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
                if (serviceClass.getName().equals(service.service.getClassName())) {
                    return true;
                }
            }
        } catch (Exception exception) {
            AlertDialogBuilder.show(SplashActivity.this, exception.getMessage());
        }
        return false;
    }

    public void tryConnect() {
        try {
            String token = SP.getString("driver_token", null);
            if (token != null && !token.isEmpty()) {
                eventBus.post(new ConnectEvent(token));
            } else {
                binding.loginButton.setVisibility(View.VISIBLE);
                binding.progressBar.setVisibility(View.INVISIBLE);
            }
        } catch (Exception ignored) {
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onConnectedResult(ConnectResultEvent event) {
        if (event.hasError()) {
            binding.progressBar.setVisibility(View.INVISIBLE);
            event.showError(SplashActivity.this, new AlertDialogEvent() {
                @Override
                public void onAnswerDialog(AlertDialogBuilder.DialogResult result) {
                    if (result == AlertDialogBuilder.DialogResult.RETRY) {
                        eventBus.post(new ConnectEvent(SP.getString("driver_token", null)));
                        binding.progressBar.setVisibility(View.VISIBLE);
                    } else {
                        binding.loginButton.setVisibility(View.VISIBLE);
                    }
                }
            });
            return;
        }

        CommonUtils.driver = new Gson().fromJson(SP.getString("driver_user", "{}"), Driver.class);
        startMainActivity();
    }

    @Subscribe
    public void onServiceStarted(BackgroundServiceStartedEvent event) {
        tryConnect();
    }



    @Subscribe
    public void onLoginResultEvent(LoginResultEvent event) {
        if (event.hasError()) {
            event.showError(SplashActivity.this, new AlertDialogEvent() {
                @Override
                public void onAnswerDialog(AlertDialogBuilder.DialogResult result) {
                    if (result == AlertDialogBuilder.DialogResult.RETRY)
                        binding.loginButton.callOnClick();
                    else
                        finish();
                }
            });
            return;
        }
        CommonUtils.driver = event.driver;
        SP.putString("driver_user", event.driverJson);
        SP.putString("driver_token", event.jwtToken);
        tryConnect();

    }

    @Override
    protected void onResume() {
        super.onResume();
        tryConnect();
    }
    private void startMainActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
    }
    private void tryLogin(String phone) {
        binding.progressBar.setVisibility(View.VISIBLE);
        if (phone.substring(0, 1).equals("+"))
            phone = phone.substring(1);
        eventBus.post(new LoginEvent(Long.valueOf(phone), BuildConfig.VERSION_CODE));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                IdpResponse idpResponse = IdpResponse.fromResultIntent(data);
                String phone = idpResponse.getPhoneNumber();
                if (phone != null)
                    tryLogin(phone);
                return;
            }
            AlerterHelper.showError(SplashActivity.this, getString(R.string.login_failed));
        }
    }
}
