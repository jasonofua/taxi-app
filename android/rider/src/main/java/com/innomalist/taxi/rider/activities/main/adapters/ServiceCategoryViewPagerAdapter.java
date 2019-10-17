package com.innomalist.taxi.rider.activities.main.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.innomalist.taxi.common.models.ServiceCategory;
import com.innomalist.taxi.rider.activities.main.fragments.ServiceCarousalFragment;

import java.util.ArrayList;

public class ServiceCategoryViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<ServiceCategory> list;

    public ServiceCategoryViewPagerAdapter(FragmentManager manager, ArrayList<ServiceCategory> list) {
        super(manager);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return ServiceCarousalFragment.newInstance(list.get(position).getServices());
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getCatTitle();
    }
}