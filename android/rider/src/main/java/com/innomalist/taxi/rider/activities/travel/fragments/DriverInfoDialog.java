package com.innomalist.taxi.rider.activities.travel.fragments;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.innomalist.taxi.common.models.Driver;
import com.innomalist.taxi.common.models.Review;
import com.innomalist.taxi.common.utils.CommonUtils;
import com.innomalist.taxi.rider.R;
import com.innomalist.taxi.rider.databinding.CardDriverInfoBinding;
import com.innomalist.taxi.rider.databinding.FragmentReviewBinding;


public class DriverInfoDialog extends AppCompatDialogFragment {
    private static String ARG_DRIVER = "arg_driver";
    CardDriverInfoBinding binding;


    public DriverInfoDialog() {
        // Required empty public constructor
    }

    public static DriverInfoDialog newInstance(Driver driver) {
        DriverInfoDialog fragment = new DriverInfoDialog();
        Bundle args = new Bundle();
        args.putSerializable(ARG_DRIVER, driver);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.card_driver_info, container, false);
        binding.setDriver(CommonUtils.driver);
        return binding.getRoot();
    }

    /*@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("Review");
        View view = onCreateDialogView(getActivity().getLayoutInflater(), null, null);
        onViewCreated(view, null);
        alertDialogBuilder.setView(view);

        alertDialogBuilder.setPositiveButton("OK", (dialog, which) -> {
        });
        alertDialogBuilder.setNegativeButton("Cancel", (dialog, which) -> {
            if (dialog != null) {
                dialog.dismiss();
            }
        });

        return alertDialogBuilder.create();
    }*/
}
