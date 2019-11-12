package com.innomalist.taxi.rider.databinding;
import com.innomalist.taxi.rider.R;
import com.innomalist.taxi.rider.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class CardDriverAcceptedBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.image_header, 7);
        sViewsWithIds.put(R.id.image_driver, 8);
        sViewsWithIds.put(R.id.label_distance, 9);
        sViewsWithIds.put(R.id.label_duration, 10);
        sViewsWithIds.put(R.id.label_cost, 11);
        sViewsWithIds.put(R.id.label_rating, 12);
        sViewsWithIds.put(R.id.button_accept, 13);
    }
    // views
    @NonNull
    public final android.support.v7.widget.AppCompatButton buttonAccept;
    @NonNull
    public final de.hdodenhof.circleimageview.CircleImageView imageDriver;
    @NonNull
    public final android.widget.ImageView imageHeader;
    @NonNull
    public final android.widget.TextView labelCost;
    @NonNull
    public final android.widget.TextView labelDistance;
    @NonNull
    public final android.widget.TextView labelDuration;
    @NonNull
    public final android.widget.TextView labelRating;
    @NonNull
    private final android.support.v7.widget.CardView mboundView0;
    @NonNull
    public final android.widget.TextView textCarName;
    @NonNull
    public final android.widget.TextView textCost;
    @NonNull
    public final android.widget.TextView textDistance;
    @NonNull
    public final android.widget.TextView textDriverName;
    @NonNull
    public final android.widget.TextView textDuration;
    @NonNull
    public final android.widget.TextView textRating;
    // variables
    @Nullable
    private com.innomalist.taxi.common.models.DriverInfo mInfo;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public CardDriverAcceptedBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds);
        this.buttonAccept = (android.support.v7.widget.AppCompatButton) bindings[13];
        this.imageDriver = (de.hdodenhof.circleimageview.CircleImageView) bindings[8];
        this.imageHeader = (android.widget.ImageView) bindings[7];
        this.labelCost = (android.widget.TextView) bindings[11];
        this.labelDistance = (android.widget.TextView) bindings[9];
        this.labelDuration = (android.widget.TextView) bindings[10];
        this.labelRating = (android.widget.TextView) bindings[12];
        this.mboundView0 = (android.support.v7.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.textCarName = (android.widget.TextView) bindings[2];
        this.textCarName.setTag(null);
        this.textCost = (android.widget.TextView) bindings[5];
        this.textCost.setTag(null);
        this.textDistance = (android.widget.TextView) bindings[3];
        this.textDistance.setTag(null);
        this.textDriverName = (android.widget.TextView) bindings[1];
        this.textDriverName.setTag(null);
        this.textDuration = (android.widget.TextView) bindings[4];
        this.textDuration.setTag(null);
        this.textRating = (android.widget.TextView) bindings[6];
        this.textRating.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
        if (BR.info == variableId) {
            setInfo((com.innomalist.taxi.common.models.DriverInfo) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setInfo(@Nullable com.innomalist.taxi.common.models.DriverInfo Info) {
        this.mInfo = Info;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.info);
        super.requestRebind();
    }
    @Nullable
    public com.innomalist.taxi.common.models.DriverInfo getInfo() {
        return mInfo;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeInfoDriver((com.innomalist.taxi.common.models.Driver) object, fieldId);
        }
        return false;
    }
    private boolean onChangeInfoDriver(com.innomalist.taxi.common.models.Driver InfoDriver, int fieldId) {
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
        java.lang.String textDistanceAndroidStringUnitDistanceInfoDistance = null;
        com.innomalist.taxi.common.models.Car infoDriverCar = null;
        java.lang.String infoDriverRatingToString = null;
        com.innomalist.taxi.common.models.Driver infoDriver = null;
        java.lang.String infoDriverFirstName = null;
        int androidDatabindingDynamicUtilSafeUnboxInfoDriverRating = 0;
        java.lang.String infoDriverCarTitle = null;
        boolean infoDriverRatingInt0 = false;
        java.lang.Integer infoDuration = null;
        java.lang.String infoDriverFirstNameCharInfoDriverLastName = null;
        java.lang.String infoDriverFirstNameChar = null;
        java.lang.Integer infoDriverRating = null;
        com.innomalist.taxi.common.models.DriverInfo info = mInfo;
        java.lang.String infoDriverLastName = null;
        java.lang.String textDurationAndroidStringUnitMinuteInfoDuration = null;
        java.lang.Double infoDistance = null;
        java.lang.String infoDriverRatingInt0InfoDriverRatingToStringJavaLangString = null;
        java.lang.Double infoCost = null;
        java.lang.String textCostAndroidStringUnitMoneyInfoCost = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (info != null) {
                    // read info.driver
                    infoDriver = info.driver;
                }
                updateRegistration(0, infoDriver);


                if (infoDriver != null) {
                    // read info.driver.car
                    infoDriverCar = infoDriver.getCar();
                    // read info.driver.firstName
                    infoDriverFirstName = infoDriver.getFirstName();
                    // read info.driver.rating
                    infoDriverRating = infoDriver.getRating();
                    // read info.driver.lastName
                    infoDriverLastName = infoDriver.getLastName();
                }


                if (infoDriverCar != null) {
                    // read info.driver.car.title
                    infoDriverCarTitle = infoDriverCar.getTitle();
                }
                // read (info.driver.firstName) + (' ')
                infoDriverFirstNameChar = (infoDriverFirstName) + (' ');
                // read android.databinding.DynamicUtil.safeUnbox(info.driver.rating)
                androidDatabindingDynamicUtilSafeUnboxInfoDriverRating = android.databinding.DynamicUtil.safeUnbox(infoDriverRating);


                // read ((info.driver.firstName) + (' ')) + (info.driver.lastName)
                infoDriverFirstNameCharInfoDriverLastName = (infoDriverFirstNameChar) + (infoDriverLastName);
                // read android.databinding.DynamicUtil.safeUnbox(info.driver.rating) != 0
                infoDriverRatingInt0 = (androidDatabindingDynamicUtilSafeUnboxInfoDriverRating) != (0);
            if((dirtyFlags & 0x7L) != 0) {
                if(infoDriverRatingInt0) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }
            if ((dirtyFlags & 0x6L) != 0) {

                    if (info != null) {
                        // read info.duration
                        infoDuration = info.duration;
                        // read info.distance
                        infoDistance = info.distance;
                        // read info.cost
                        infoCost = info.cost;
                    }


                    // read @android:string/unit_minute
                    textDurationAndroidStringUnitMinuteInfoDuration = textDuration.getResources().getString(R.string.unit_minute, infoDuration);
                    // read @android:string/unit_distance
                    textDistanceAndroidStringUnitDistanceInfoDistance = textDistance.getResources().getString(R.string.unit_distance, infoDistance);
                    // read @android:string/unit_money
                    textCostAndroidStringUnitMoneyInfoCost = textCost.getResources().getString(R.string.unit_money, infoCost);
            }
        }
        // batch finished

        if ((dirtyFlags & 0x10L) != 0) {

                if (infoDriverRating != null) {
                    // read info.driver.rating.toString()
                    infoDriverRatingToString = infoDriverRating.toString();
                }
        }

        if ((dirtyFlags & 0x7L) != 0) {

                // read android.databinding.DynamicUtil.safeUnbox(info.driver.rating) != 0 ? info.driver.rating.toString() : "-"
                infoDriverRatingInt0InfoDriverRatingToStringJavaLangString = ((infoDriverRatingInt0) ? (infoDriverRatingToString) : ("-"));
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.textCarName, infoDriverCarTitle);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textDriverName, infoDriverFirstNameCharInfoDriverLastName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textRating, infoDriverRatingInt0InfoDriverRatingToStringJavaLangString);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.textCost, textCostAndroidStringUnitMoneyInfoCost);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textDistance, textDistanceAndroidStringUnitDistanceInfoDistance);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textDuration, textDurationAndroidStringUnitMinuteInfoDuration);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static CardDriverAcceptedBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static CardDriverAcceptedBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<CardDriverAcceptedBinding>inflate(inflater, com.innomalist.taxi.rider.R.layout.card_driver_accepted, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static CardDriverAcceptedBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static CardDriverAcceptedBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.innomalist.taxi.rider.R.layout.card_driver_accepted, null, false), bindingComponent);
    }
    @NonNull
    public static CardDriverAcceptedBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static CardDriverAcceptedBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/card_driver_accepted_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new CardDriverAcceptedBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): info.driver
        flag 1 (0x2L): info
        flag 2 (0x3L): null
        flag 3 (0x4L): android.databinding.DynamicUtil.safeUnbox(info.driver.rating) != 0 ? info.driver.rating.toString() : "-"
        flag 4 (0x5L): android.databinding.DynamicUtil.safeUnbox(info.driver.rating) != 0 ? info.driver.rating.toString() : "-"
    flag mapping end*/
    //end
}