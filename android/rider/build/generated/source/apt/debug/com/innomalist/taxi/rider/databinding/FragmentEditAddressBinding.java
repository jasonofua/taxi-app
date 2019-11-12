package com.innomalist.taxi.rider.databinding;
import com.innomalist.taxi.rider.R;
import com.innomalist.taxi.rider.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class FragmentEditAddressBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.text_title, 3);
        sViewsWithIds.put(R.id.text_address, 4);
    }
    // views
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    @NonNull
    private final android.support.design.widget.TextInputEditText mboundView1;
    @NonNull
    private final android.support.design.widget.TextInputEditText mboundView2;
    @NonNull
    public final android.support.design.widget.TextInputLayout textAddress;
    @NonNull
    public final android.support.design.widget.TextInputLayout textTitle;
    // variables
    @Nullable
    private com.innomalist.taxi.common.models.Address mAddress;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentEditAddressBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.support.design.widget.TextInputEditText) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.support.design.widget.TextInputEditText) bindings[2];
        this.mboundView2.setTag(null);
        this.textAddress = (android.support.design.widget.TextInputLayout) bindings[4];
        this.textTitle = (android.support.design.widget.TextInputLayout) bindings[3];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.address == variableId) {
            setAddress((com.innomalist.taxi.common.models.Address) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setAddress(@Nullable com.innomalist.taxi.common.models.Address Address) {
        this.mAddress = Address;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.address);
        super.requestRebind();
    }
    @Nullable
    public com.innomalist.taxi.common.models.Address getAddress() {
        return mAddress;
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
        com.innomalist.taxi.common.models.Address address = mAddress;
        java.lang.String addressAddress = null;
        java.lang.String addressTitle = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (address != null) {
                    // read address.address
                    addressAddress = address.getAddress();
                    // read address.title
                    addressTitle = address.getTitle();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, addressTitle);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, addressAddress);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FragmentEditAddressBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentEditAddressBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentEditAddressBinding>inflate(inflater, com.innomalist.taxi.rider.R.layout.fragment_edit_address, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FragmentEditAddressBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentEditAddressBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.innomalist.taxi.rider.R.layout.fragment_edit_address, null, false), bindingComponent);
    }
    @NonNull
    public static FragmentEditAddressBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentEditAddressBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_edit_address_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentEditAddressBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): address
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}