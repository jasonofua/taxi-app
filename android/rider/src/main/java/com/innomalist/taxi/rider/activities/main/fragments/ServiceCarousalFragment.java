package com.innomalist.taxi.rider.activities.main.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.innomalist.taxi.common.models.Service;
import com.innomalist.taxi.common.utils.ItemClickSupport;
import com.innomalist.taxi.rider.activities.main.adapters.ServicesListAdapter;
import com.innomalist.taxi.rider.ui.gravitySnapHelper.GravitySnapHelper;

import java.util.ArrayList;
import java.util.List;

public class ServiceCarousalFragment extends Fragment {
    private static final String ARG_SERVICES = "services";

    private List<Service> services;

    private OnServicesCarousalFragmentListener mListener;

    public ServiceCarousalFragment() {
        // Required empty public constructor
    }

    public static ServiceCarousalFragment newInstance(ArrayList<Service> services) {
        ServiceCarousalFragment fragment = new ServiceCarousalFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_SERVICES, services);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            services = (ArrayList<Service>) getArguments().getSerializable(ARG_SERVICES);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        SnapHelper snapHelper = new GravitySnapHelper(Gravity.START);
        snapHelper.attachToRecyclerView(recyclerView);
        ServicesListAdapter adapter = new ServicesListAdapter(services);
        recyclerView.setAdapter(adapter);
        /*Display display = getActivity().getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        float density  = getResources().getDisplayMetrics().density;
        int dpWidth  = (int)(outMetrics.widthPixels / density);
        recyclerView.addItemDecoration(new SmartPaddingForLinearSnapHelper(getContext(),dpWidth));*/
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener((recyclerView1, position, v) -> mListener.onServiceSelected(services.get(position)));
        return recyclerView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnServicesCarousalFragmentListener) {
            mListener = (OnServicesCarousalFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnServicesCarousalFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnServicesCarousalFragmentListener {
        void onServiceSelected(Service service);
    }
}
