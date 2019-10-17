package com.innomalist.taxi.rider.activities.addresses;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.model.LatLng;
import com.innomalist.taxi.common.components.BaseActivity;
import com.innomalist.taxi.common.models.Address;
import com.innomalist.taxi.common.models.CRUD;
import com.innomalist.taxi.common.utils.LocationHelper;
import com.innomalist.taxi.rider.R;
import com.innomalist.taxi.rider.activities.addresses.adapters.AddressesRecyclerViewAdapter;
import com.innomalist.taxi.rider.activities.addresses.fragments.EditAddressDialog;
import com.innomalist.taxi.rider.activities.main.MainActivity;
import com.innomalist.taxi.rider.databinding.ActivityAddressesBinding;
import com.innomalist.taxi.rider.events.CRUDAddressRequestEvent;
import com.innomalist.taxi.rider.events.CRUDAddressResultEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class AddressesActivity extends BaseActivity implements EditAddressDialog.onEditAddressInteractionListener {
    ActivityAddressesBinding binding;
    LatLng currentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = DataBindingUtil.setContentView(AddressesActivity.this, R.layout.activity_addresses);
        currentLocation = LocationHelper.DoubleArrayToLatLng(getIntent().getDoubleArrayExtra("currentLocation"));
        initializeToolbar(getString(R.string.activity_address_title));
        eventBus.post(new CRUDAddressRequestEvent(CRUD.READ));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Address address = new Address();
        address.setLocation(currentLocation);
        showEditAddressDialog(address);
        return super.onOptionsItemSelected(item);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCRUDResultReceived(CRUDAddressResultEvent event) {
        if (event.addresses != null) {
            AddressesRecyclerViewAdapter restaurantsListRecyclerView = new AddressesRecyclerViewAdapter(event.addresses, new AddressesRecyclerViewAdapter.OnAddressItemInteractionListener() {
                @Override
                public void onEdit(Address address) {
                    showEditAddressDialog(address);
                }

                @Override
                public void onDelete(Address address) {
                    eventBus.post(new CRUDAddressRequestEvent(CRUD.DELETE, address));
                }
            });
            LinearLayoutManager llm = new LinearLayoutManager(AddressesActivity.this);
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            llm.setAutoMeasureEnabled(false);
            binding.recyclerView.setHasFixedSize(true);
            binding.recyclerView.setLayoutManager(llm);
            binding.recyclerView.setAdapter(restaurantsListRecyclerView);
        }
        if(event.crud == CRUD.DELETE || event.crud == CRUD.UPDATE || event.crud == CRUD.CREATE) {
            eventBus.post(new CRUDAddressRequestEvent(CRUD.READ));
        }
    }

    public void showEditAddressDialog(Address address) {
        FragmentManager fm = getSupportFragmentManager();
        EditAddressDialog editNameDialogFragment = EditAddressDialog.newInstance(address);
        editNameDialogFragment.show(fm, "fragment_edit_name");

    }

    @Override
    public void onSaveButtonClicked(Address address) {
        if(address.getId() != 0)
            eventBus.post(new CRUDAddressRequestEvent(CRUD.UPDATE, address));
        else
            eventBus.post(new CRUDAddressRequestEvent(CRUD.CREATE, address));
    }

    private interface EditAddressResult {
        void onAddressEdited(Address address);
    }

}
