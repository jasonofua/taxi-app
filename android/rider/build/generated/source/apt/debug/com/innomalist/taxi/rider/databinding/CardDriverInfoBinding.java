package com.innomalist.taxi.rider.databinding;
import com.innomalist.taxi.rider.R;
import com.innomalist.taxi.rider.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class CardDriverInfoBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.image_header, 6);
        sViewsWithIds.put(R.id.image_driver, 7);
        sViewsWithIds.put(R.id.label_id, 8);
        sViewsWithIds.put(R.id.label_plate, 9);
        sViewsWithIds.put(R.id.label_rating, 10);
    }
    // views
    @NonNull
    public final android.support.constraint.ConstraintLayout frameLayout;
    @NonNull
    public final de.hdodenhof.circleimageview.CircleImageView imageDriver;
    @NonNull
    public final android.widget.ImageView imageHeader;
    @NonNull
    public final android.widget.TextView labelId;
    @NonNull
    public final android.widget.TextView labelPlate;
    @NonNull
    public final android.widget.TextView labelRating;
    @NonNull
    public final android.widget.TextView textCarName;
    @NonNull
    public final android.widget.TextView textDriverName;
    @NonNull
    public final android.widget.TextView textId;
    @NonNull
    public final android.widget.TextView textPlate;
    @NonNull
    public final android.widget.TextView textRating;
    // variables
    @Nullable
    private com.innomalist.taxi.common.models.Driver mDriver;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public CardDriverInfoBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds);
        this.frameLayout = (android.support.constraint.ConstraintLayout) bindings[0];
        this.frameLayout.setTag(null);
        this.imageDriver = (de.hdodenhof.circleimageview.CircleImageView) bindings[7];
        this.imageHeader = (android.widget.ImageView) bindings[6];
        this.labelId = (android.widget.TextView) bindings[8];
        this.labelPlate = (android.widget.TextView) bindings[9];
        this.labelRating = (android.widget.TextView) bindings[10];
        this.textCarName = (android.widget.TextView) bindings[2];
        this.textCarName.setTag(null);
        this.textDriverName = (android.widget.TextView) bindings[1];
        this.textDriverName.setTag(null);
        this.textId = (android.widget.TextView) bindings[3];
        this.textId.setTag(null);
        this.textPlate = (android.widget.TextView) bindings[4];
        this.textPlate.setTag(null);
        this.textRating = (android.widget.TextView) bindings[5];
        this.textRating.setTag(null);
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
        if (BR.driver == variableId) {
            setDriver((com.innomalist.taxi.common.models.Driver) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setDriver(@Nullable com.innomalist.taxi.common.models.Driver Driver) {
        updateRegistration(0, Driver);
        this.mDriver = Driver;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.driver);
        super.requestRebind();
    }
    @Nullable
    public com.innomalist.taxi.common.models.Driver getDriver() {
        return mDriver;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeDriver((com.innomalist.taxi.common.models.Driver) object, fieldId);
        }
        return false;
    }
    private boolean onChangeDriver(com.innomalist.taxi.common.models.Driver Driver, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        int driverId = 0;
        java.lang.String stringValueOfDriverId = null;
        java.lang.String driverFirstNameChar = null;
        java.lang.String driverFirstNameCharDriverLastName = null;
        java.lang.String driverFirstName = null;
        java.lang.String driverRatingInt0DriverRatingToStringJavaLangString = null;
        java.lang.String driverRatingToString = null;
        boolean driverRatingInt0 = false;
        com.innomalist.taxi.common.models.Driver driver = mDriver;
        int androidDatabindingDynamicUtilSafeUnboxDriverRating = 0;
        java.lang.String driverCarTitle = null;
        java.lang.String driverLastName = null;
        java.lang.String driverCarPlate = null;
        java.lang.Integer driverRating = null;
        com.innomalist.taxi.common.models.Car driverCar = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (driver != null) {
                    // read driver.id
                    driverId = driver.getId();
                    // read driver.firstName
                    driverFirstName = driver.getFirstName();
                    // read driver.lastName
                    driverLastName = driver.getLastName();
                    // read driver.carPlate
                    driverCarPlate = driver.getCarPlate();
                    // read driver.rating
                    driverRating = driver.getRating();
                    // read driver.car
                    driverCar = driver.getCar();
                }


                // read String.valueOf(driver.id)
                stringValueOfDriverId = java.lang.String.valueOf(driverId);
                // read (driver.firstName) + (' ')
                driverFirstNameChar = (driverFirstName) + (' ');
                // read android.databinding.DynamicUtil.safeUnbox(driver.rating)
                androidDatabindingDynamicUtilSafeUnboxDriverRating = android.databinding.DynamicUtil.safeUnbox(driverRating);
                if (driverCar != null) {
                    // read driver.car.title
                    driverCarTitle = driverCar.getTitle();
                }


                // read ((driver.firstName) + (' ')) + (driver.lastName)
                driverFirstNameCharDriverLastName = (driverFirstNameChar) + (driverLastName);
                // read android.databinding.DynamicUtil.safeUnbox(driver.rating) != 0
                driverRatingInt0 = (androidDatabindingDynamicUtilSafeUnboxDriverRating) != (0);
            if((dirtyFlags & 0x3L) != 0) {
                if(driverRatingInt0) {
                        dirtyFlags |= 0x8L;
                }
                else {
                        dirtyFlags |= 0x4L;
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x8L) != 0) {

                if (driverRating != null) {
                    // read driver.rating.toString()
                    driverRatingToString = driverRating.toString();
                }
        }

        if ((dirtyFlags & 0x3L) != 0) {

                // read android.databinding.DynamicUtil.safeUnbox(driver.rating) != 0 ? driver.rating.toString() : "-"
                driverRatingInt0DriverRatingToStringJavaLangString = ((driverRatingInt0) ? (driverRatingToString) : ("-"));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.textCarName, driverCarTitle);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textDriverName, driverFirstNameCharDriverLastName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textId, stringValueOfDriverId);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textPlate, driverCarPlate);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textRating, driverRatingInt0DriverRatingToStringJavaLangString);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static CardDriverInfoBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static CardDriverInfoBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<CardDriverInfoBinding>inflate(inflater, com.innomalist.taxi.rider.R.layout.card_driver_info, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static CardDriverInfoBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static CardDriverInfoBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.innomalist.taxi.rider.R.layout.card_driver_info, null, false), bindingComponent);
    }
    @NonNull
    public static CardDriverInfoBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static CardDriverInfoBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/card_driver_info_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new CardDriverInfoBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): driver
        flag 1 (0x2L): null
        flag 2 (0x3L): android.databinding.DynamicUtil.safeUnbox(driver.rating) != 0 ? driver.rating.toString() : "-"
        flag 3 (0x4L): android.databinding.DynamicUtil.safeUnbox(driver.rating) != 0 ? driver.rating.toString() : "-"
    flag mapping end*/
    //end
}