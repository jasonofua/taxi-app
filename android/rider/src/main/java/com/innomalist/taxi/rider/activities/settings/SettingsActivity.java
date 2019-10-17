package com.innomalist.taxi.rider.activities.settings;

import android.os.Bundle;

import com.innomalist.taxi.common.components.BaseActivity;
import com.innomalist.taxi.rider.R;

public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        registerEventBus = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initializeToolbar(getString(R.string.activity_settings));
    }
}
