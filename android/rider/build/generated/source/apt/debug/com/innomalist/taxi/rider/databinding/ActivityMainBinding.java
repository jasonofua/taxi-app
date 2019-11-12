package com.innomalist.taxi.rider.databinding;
import com.innomalist.taxi.rider.R;
import com.innomalist.taxi.rider.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityMainBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.map_layout, 1);
        sViewsWithIds.put(R.id.search_place, 2);
        sViewsWithIds.put(R.id.search_text, 3);
        sViewsWithIds.put(R.id.image_marker, 4);
        sViewsWithIds.put(R.id.button_confirm_pickup, 5);
        sViewsWithIds.put(R.id.button_confirm_destination, 6);
        sViewsWithIds.put(R.id.bottom_sheet, 7);
        sViewsWithIds.put(R.id.button_request, 8);
        sViewsWithIds.put(R.id.tab_categories, 9);
        sViewsWithIds.put(R.id.service_types_view_pager, 10);
        sViewsWithIds.put(R.id.navigation_view, 11);
    }
    // views
    @NonNull
    public final android.support.v7.widget.CardView bottomSheet;
    @NonNull
    public final android.widget.Button buttonConfirmDestination;
    @NonNull
    public final android.widget.Button buttonConfirmPickup;
    @NonNull
    public final android.widget.Button buttonRequest;
    @NonNull
    public final android.support.v4.widget.DrawerLayout drawerLayout;
    @NonNull
    public final android.widget.ImageView imageMarker;
    @NonNull
    public final android.widget.LinearLayout mapLayout;
    @NonNull
    public final android.support.design.widget.NavigationView navigationView;
    @NonNull
    public final com.arlib.floatingsearchview.FloatingSearchView searchPlace;
    @NonNull
    public final android.widget.TextView searchText;
    @NonNull
    public final android.support.v4.view.ViewPager serviceTypesViewPager;
    @NonNull
    public final android.support.design.widget.TabLayout tabCategories;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds);
        this.bottomSheet = (android.support.v7.widget.CardView) bindings[7];
        this.buttonConfirmDestination = (android.widget.Button) bindings[6];
        this.buttonConfirmPickup = (android.widget.Button) bindings[5];
        this.buttonRequest = (android.widget.Button) bindings[8];
        this.drawerLayout = (android.support.v4.widget.DrawerLayout) bindings[0];
        this.drawerLayout.setTag(null);
        this.imageMarker = (android.widget.ImageView) bindings[4];
        this.mapLayout = (android.widget.LinearLayout) bindings[1];
        this.navigationView = (android.support.design.widget.NavigationView) bindings[11];
        this.searchPlace = (com.arlib.floatingsearchview.FloatingSearchView) bindings[2];
        this.searchText = (android.widget.TextView) bindings[3];
        this.serviceTypesViewPager = (android.support.v4.view.ViewPager) bindings[10];
        this.tabCategories = (android.support.design.widget.TabLayout) bindings[9];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityMainBinding>inflate(inflater, com.innomalist.taxi.rider.R.layout.activity_main, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.innomalist.taxi.rider.R.layout.activity_main, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityMainBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMainBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_main_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityMainBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}