package com.innomalist.taxi.rider.activities.addresses.fragments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.innomalist.taxi.common.models.Address;
import com.innomalist.taxi.rider.R;
import com.innomalist.taxi.rider.databinding.FragmentEditAddressBinding;


public class EditAddressDialog extends DialogFragment implements OnMapReadyCallback {
    FragmentEditAddressBinding binding;
    private static final String ARG_ADDRESS = "address";
    private Address address;
    GoogleMap googleMap;
    SupportMapFragment mapFragment;
    private onEditAddressInteractionListener mListener;

    public EditAddressDialog() {
        // Required empty public constructor
    }

    public static EditAddressDialog newInstance(Address param1) {
        EditAddressDialog fragment = new EditAddressDialog();
        Bundle args = new Bundle();
        args.putSerializable(ARG_ADDRESS, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            address = (Address) getArguments().getSerializable(ARG_ADDRESS);
        }
    }

    public View onCreateDialogView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_address,container,false);
        binding.setAddress(address);
        return binding.getRoot();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(R.string.edit_address_dialog_title);
        View view = onCreateDialogView(getActivity().getLayoutInflater(), null, null);
        onViewCreated(view, null);
        alertDialogBuilder.setView(view);
        mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        alertDialogBuilder.setPositiveButton(getString(R.string.alert_ok), (dialog, which) -> {
            address.setTitle(binding.textTitle.getEditText().getText().toString());
            address.setAddress(binding.textAddress.getEditText().getText().toString());
            address.setLocation(googleMap.getCameraPosition().target);
            mListener.onSaveButtonClicked(address);
        });
        alertDialogBuilder.setNegativeButton(getString(R.string.alert_cancel), (dialog, which) -> {
            if (dialog != null) {
                dialog.dismiss();
            }
        });

        return alertDialogBuilder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onEditAddressInteractionListener) {
            mListener = (onEditAddressInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement onEditAddressInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;

    }
    @Override
    public void onPause() {
        if(mapFragment != null){
            getActivity().getSupportFragmentManager().beginTransaction().remove(mapFragment).commitAllowingStateLoss();
        }
        super.onPause();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        if(address.getLocation()!=null)
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(address.getLocation(),16f));
    }

    public interface onEditAddressInteractionListener {
        void onSaveButtonClicked(Address address);
    }
}
