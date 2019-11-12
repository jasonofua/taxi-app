package com.innomalist.taxi.common.databinding;
import com.innomalist.taxi.common.R;
import com.innomalist.taxi.common.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ItemTravelBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cell_content_view, 10);
        sViewsWithIds.put(R.id.constraint_id, 11);
        sViewsWithIds.put(R.id.text_status, 12);
        sViewsWithIds.put(R.id.label_from, 13);
        sViewsWithIds.put(R.id.label_to, 14);
        sViewsWithIds.put(R.id.divider_address, 15);
        sViewsWithIds.put(R.id.label_request_time, 16);
        sViewsWithIds.put(R.id.text_request_time, 17);
        sViewsWithIds.put(R.id.text_request_date, 18);
        sViewsWithIds.put(R.id.label_finish_time, 19);
        sViewsWithIds.put(R.id.text_finish_time, 20);
        sViewsWithIds.put(R.id.text_finish_date, 21);
        sViewsWithIds.put(R.id.divider_details, 22);
        sViewsWithIds.put(R.id.label_details_cost, 23);
        sViewsWithIds.put(R.id.text_details_cost, 24);
        sViewsWithIds.put(R.id.label_details_distance, 25);
        sViewsWithIds.put(R.id.text_details_distance, 26);
        sViewsWithIds.put(R.id.button_hide_travel, 27);
        sViewsWithIds.put(R.id.button_Complaint, 28);
        sViewsWithIds.put(R.id.cell_title_view, 29);
        sViewsWithIds.put(R.id.constraint_header, 30);
        sViewsWithIds.put(R.id.title_date_label, 31);
        sViewsWithIds.put(R.id.title_time_label, 32);
        sViewsWithIds.put(R.id.constraint_content, 33);
        sViewsWithIds.put(R.id.title_from_to_dots, 34);
        sViewsWithIds.put(R.id.title_from_to_dots_divider, 35);
        sViewsWithIds.put(R.id.label_cost, 36);
        sViewsWithIds.put(R.id.label_distance, 37);
        sViewsWithIds.put(R.id.label_duration, 38);
        sViewsWithIds.put(R.id.text_duration, 39);
    }
    // views
    @NonNull
    public final android.widget.Button buttonComplaint;
    @NonNull
    public final android.widget.Button buttonHideTravel;
    @NonNull
    public final android.support.v7.widget.CardView cellContentView;
    @NonNull
    public final android.support.v7.widget.CardView cellTitleView;
    @NonNull
    public final android.support.constraint.ConstraintLayout constraintContent;
    @NonNull
    public final android.support.constraint.ConstraintLayout constraintHeader;
    @NonNull
    public final android.support.constraint.ConstraintLayout constraintId;
    @NonNull
    public final android.widget.ImageView dividerAddress;
    @NonNull
    public final android.widget.ImageView dividerDetails;
    @NonNull
    public final com.ramotion.foldingcell.FoldingCell exTravel;
    @NonNull
    public final android.widget.ImageView imageMap;
    @NonNull
    public final android.widget.TextView labelCost;
    @NonNull
    public final android.widget.TextView labelDetailsCost;
    @NonNull
    public final android.widget.TextView labelDetailsDistance;
    @NonNull
    public final android.widget.TextView labelDistance;
    @NonNull
    public final android.widget.TextView labelDuration;
    @NonNull
    public final android.widget.TextView labelFinishTime;
    @NonNull
    public final android.widget.TextView labelFrom;
    @NonNull
    public final android.widget.TextView labelRequestTime;
    @NonNull
    public final android.widget.TextView labelTo;
    @NonNull
    private final android.widget.TextView mboundView1;
    @NonNull
    public final android.widget.TextView textCost;
    @NonNull
    public final android.widget.TextView textDetailsCost;
    @NonNull
    public final android.widget.TextView textDetailsDistance;
    @NonNull
    public final android.widget.TextView textDistance;
    @NonNull
    public final android.widget.TextView textDuration;
    @NonNull
    public final android.widget.TextView textFinishDate;
    @NonNull
    public final android.widget.TextView textFinishTime;
    @NonNull
    public final android.widget.TextView textFrom;
    @NonNull
    public final android.widget.TextView textRequestDate;
    @NonNull
    public final android.widget.TextView textRequestTime;
    @NonNull
    public final android.widget.TextView textStatus;
    @NonNull
    public final android.widget.TextView textTo;
    @NonNull
    public final android.widget.TextView titleDateLabel;
    @NonNull
    public final android.widget.TextView titleFromAddress;
    @NonNull
    public final android.widget.ImageView titleFromToDots;
    @NonNull
    public final android.widget.ImageView titleFromToDotsDivider;
    @NonNull
    public final android.widget.TextView titleId;
    @NonNull
    public final android.widget.TextView titleTimeLabel;
    @NonNull
    public final android.widget.TextView titleToAddress;
    // variables
    @Nullable
    private com.innomalist.taxi.common.models.Travel mItem;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemTravelBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 40, sIncludes, sViewsWithIds);
        this.buttonComplaint = (android.widget.Button) bindings[28];
        this.buttonHideTravel = (android.widget.Button) bindings[27];
        this.cellContentView = (android.support.v7.widget.CardView) bindings[10];
        this.cellTitleView = (android.support.v7.widget.CardView) bindings[29];
        this.constraintContent = (android.support.constraint.ConstraintLayout) bindings[33];
        this.constraintHeader = (android.support.constraint.ConstraintLayout) bindings[30];
        this.constraintId = (android.support.constraint.ConstraintLayout) bindings[11];
        this.dividerAddress = (android.widget.ImageView) bindings[15];
        this.dividerDetails = (android.widget.ImageView) bindings[22];
        this.exTravel = (com.ramotion.foldingcell.FoldingCell) bindings[0];
        this.exTravel.setTag(null);
        this.imageMap = (android.widget.ImageView) bindings[2];
        this.imageMap.setTag(null);
        this.labelCost = (android.widget.TextView) bindings[36];
        this.labelDetailsCost = (android.widget.TextView) bindings[23];
        this.labelDetailsDistance = (android.widget.TextView) bindings[25];
        this.labelDistance = (android.widget.TextView) bindings[37];
        this.labelDuration = (android.widget.TextView) bindings[38];
        this.labelFinishTime = (android.widget.TextView) bindings[19];
        this.labelFrom = (android.widget.TextView) bindings[13];
        this.labelRequestTime = (android.widget.TextView) bindings[16];
        this.labelTo = (android.widget.TextView) bindings[14];
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        this.textCost = (android.widget.TextView) bindings[8];
        this.textCost.setTag(null);
        this.textDetailsCost = (android.widget.TextView) bindings[24];
        this.textDetailsDistance = (android.widget.TextView) bindings[26];
        this.textDistance = (android.widget.TextView) bindings[9];
        this.textDistance.setTag(null);
        this.textDuration = (android.widget.TextView) bindings[39];
        this.textFinishDate = (android.widget.TextView) bindings[21];
        this.textFinishTime = (android.widget.TextView) bindings[20];
        this.textFrom = (android.widget.TextView) bindings[3];
        this.textFrom.setTag(null);
        this.textRequestDate = (android.widget.TextView) bindings[18];
        this.textRequestTime = (android.widget.TextView) bindings[17];
        this.textStatus = (android.widget.TextView) bindings[12];
        this.textTo = (android.widget.TextView) bindings[4];
        this.textTo.setTag(null);
        this.titleDateLabel = (android.widget.TextView) bindings[31];
        this.titleFromAddress = (android.widget.TextView) bindings[6];
        this.titleFromAddress.setTag(null);
        this.titleFromToDots = (android.widget.ImageView) bindings[34];
        this.titleFromToDotsDivider = (android.widget.ImageView) bindings[35];
        this.titleId = (android.widget.TextView) bindings[5];
        this.titleId.setTag(null);
        this.titleTimeLabel = (android.widget.TextView) bindings[32];
        this.titleToAddress = (android.widget.TextView) bindings[7];
        this.titleToAddress.setTag(null);
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
        if (BR.item == variableId) {
            setItem((com.innomalist.taxi.common.models.Travel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.innomalist.taxi.common.models.Travel Item) {
        updateRegistration(0, Item);
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    @Nullable
    public com.innomalist.taxi.common.models.Travel getItem() {
        return mItem;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeItem((com.innomalist.taxi.common.models.Travel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeItem(com.innomalist.taxi.common.models.Travel Item, int fieldId) {
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
        java.lang.String itemImageUrl = null;
        com.innomalist.taxi.common.models.Travel item = mItem;
        java.lang.String stringValueOfItemId = null;
        java.lang.String textDistanceAndroidStringUnitDistanceFloatItemDistanceRealFloat1000f = null;
        java.lang.String javaLangStringItemId = null;
        java.lang.String textCostAndroidStringUnitMoneyItemCost = null;
        float floatItemDistanceRealFloat1000f = 0f;
        float floatItemDistanceReal = 0f;
        java.lang.Integer itemDistanceReal = null;
        java.lang.Double itemCost = null;
        java.lang.String itemPickupAddress = null;
        java.lang.String javaLangStringStringValueOfItemId = null;
        int androidDatabindingDynamicUtilSafeUnboxItemDistanceReal = 0;
        int androidDatabindingDynamicUtilSafeUnboxItemId = 0;
        java.lang.String itemDestinationAddress = null;
        java.lang.Integer itemId = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (item != null) {
                    // read item.imageUrl
                    itemImageUrl = item.getImageUrl();
                    // read item.distanceReal
                    itemDistanceReal = item.getDistanceReal();
                    // read item.cost
                    itemCost = item.getCost();
                    // read item.pickupAddress
                    itemPickupAddress = item.getPickupAddress();
                    // read item.destinationAddress
                    itemDestinationAddress = item.getDestinationAddress();
                    // read item.id
                    itemId = item.getId();
                }


                // read android.databinding.DynamicUtil.safeUnbox(item.distanceReal)
                androidDatabindingDynamicUtilSafeUnboxItemDistanceReal = android.databinding.DynamicUtil.safeUnbox(itemDistanceReal);
                // read @android:string/unit_money
                textCostAndroidStringUnitMoneyItemCost = textCost.getResources().getString(R.string.unit_money, itemCost);
                // read ("#") + (item.id)
                javaLangStringItemId = ("#") + (itemId);
                // read android.databinding.DynamicUtil.safeUnbox(item.id)
                androidDatabindingDynamicUtilSafeUnboxItemId = android.databinding.DynamicUtil.safeUnbox(itemId);


                // read (float) android.databinding.DynamicUtil.safeUnbox(item.distanceReal)
                floatItemDistanceReal = ((float) (androidDatabindingDynamicUtilSafeUnboxItemDistanceReal));
                // read String.valueOf(android.databinding.DynamicUtil.safeUnbox(item.id))
                stringValueOfItemId = java.lang.String.valueOf(androidDatabindingDynamicUtilSafeUnboxItemId);


                // read ((float) android.databinding.DynamicUtil.safeUnbox(item.distanceReal)) / (1000f)
                floatItemDistanceRealFloat1000f = (floatItemDistanceReal) / (1000f);
                // read ("#") + (String.valueOf(android.databinding.DynamicUtil.safeUnbox(item.id)))
                javaLangStringStringValueOfItemId = ("#") + (stringValueOfItemId);


                // read @android:string/unit_distance
                textDistanceAndroidStringUnitDistanceFloatItemDistanceRealFloat1000f = textDistance.getResources().getString(R.string.unit_distance, floatItemDistanceRealFloat1000f);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.innomalist.taxi.common.utils.DataBinder.setImageUrl(this.imageMap, itemImageUrl);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, javaLangStringStringValueOfItemId);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textCost, textCostAndroidStringUnitMoneyItemCost);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textDistance, textDistanceAndroidStringUnitDistanceFloatItemDistanceRealFloat1000f);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textFrom, itemPickupAddress);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textTo, itemDestinationAddress);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.titleFromAddress, itemPickupAddress);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.titleId, javaLangStringItemId);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.titleToAddress, itemDestinationAddress);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ItemTravelBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemTravelBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ItemTravelBinding>inflate(inflater, com.innomalist.taxi.common.R.layout.item_travel, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ItemTravelBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemTravelBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.innomalist.taxi.common.R.layout.item_travel, null, false), bindingComponent);
    }
    @NonNull
    public static ItemTravelBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemTravelBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/item_travel_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ItemTravelBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}