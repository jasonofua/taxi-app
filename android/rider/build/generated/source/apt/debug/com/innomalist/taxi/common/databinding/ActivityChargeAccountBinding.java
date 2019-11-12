package com.innomalist.taxi.common.databinding;
import com.innomalist.taxi.common.R;
import com.innomalist.taxi.common.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityChargeAccountBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.text_current_balance, 1);
        sViewsWithIds.put(R.id.title_method, 2);
        sViewsWithIds.put(R.id.layout_methods, 3);
        sViewsWithIds.put(R.id.payment_stripe, 4);
        sViewsWithIds.put(R.id.payment_online, 5);
        sViewsWithIds.put(R.id.checkout_button, 6);
        sViewsWithIds.put(R.id.layout_charges, 7);
        sViewsWithIds.put(R.id.charge_add_first, 8);
        sViewsWithIds.put(R.id.charge_add_second, 9);
        sViewsWithIds.put(R.id.charge_add_third, 10);
        sViewsWithIds.put(R.id.price_text_layout, 11);
        sViewsWithIds.put(R.id.editText, 12);
    }
    // views
    @NonNull
    public final android.widget.Button chargeAddFirst;
    @NonNull
    public final android.widget.Button chargeAddSecond;
    @NonNull
    public final android.widget.Button chargeAddThird;
    @NonNull
    public final android.widget.Button checkoutButton;
    @NonNull
    public final android.widget.EditText editText;
    @NonNull
    public final android.widget.LinearLayout layoutCharges;
    @NonNull
    public final android.widget.LinearLayout layoutMethods;
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    public final android.support.v7.widget.AppCompatImageButton paymentOnline;
    @NonNull
    public final android.support.v7.widget.AppCompatImageButton paymentStripe;
    @NonNull
    public final android.support.design.widget.TextInputLayout priceTextLayout;
    @NonNull
    public final android.widget.TextView textCurrentBalance;
    @NonNull
    public final android.widget.TextView titleMethod;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityChargeAccountBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds);
        this.chargeAddFirst = (android.widget.Button) bindings[8];
        this.chargeAddSecond = (android.widget.Button) bindings[9];
        this.chargeAddThird = (android.widget.Button) bindings[10];
        this.checkoutButton = (android.widget.Button) bindings[6];
        this.editText = (android.widget.EditText) bindings[12];
        this.layoutCharges = (android.widget.LinearLayout) bindings[7];
        this.layoutMethods = (android.widget.LinearLayout) bindings[3];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.paymentOnline = (android.support.v7.widget.AppCompatImageButton) bindings[5];
        this.paymentStripe = (android.support.v7.widget.AppCompatImageButton) bindings[4];
        this.priceTextLayout = (android.support.design.widget.TextInputLayout) bindings[11];
        this.textCurrentBalance = (android.widget.TextView) bindings[1];
        this.titleMethod = (android.widget.TextView) bindings[2];
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
    public static ActivityChargeAccountBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityChargeAccountBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityChargeAccountBinding>inflate(inflater, com.innomalist.taxi.common.R.layout.activity_charge_account, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityChargeAccountBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityChargeAccountBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.innomalist.taxi.common.R.layout.activity_charge_account, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityChargeAccountBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityChargeAccountBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_charge_account_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityChargeAccountBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}