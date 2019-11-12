package com.innomalist.taxi.common.databinding;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
@javax.annotation.Generated("Android Data Binding")
public abstract class ItemTravelBinding extends ViewDataBinding {
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
    protected com.innomalist.taxi.common.models.Travel mItem;
    protected ItemTravelBinding(@Nullable android.databinding.DataBindingComponent bindingComponent, @Nullable android.view.View root_, int localFieldCount
        , android.widget.Button buttonComplaint1
        , android.widget.Button buttonHideTravel1
        , android.support.v7.widget.CardView cellContentView1
        , android.support.v7.widget.CardView cellTitleView1
        , android.support.constraint.ConstraintLayout constraintContent1
        , android.support.constraint.ConstraintLayout constraintHeader1
        , android.support.constraint.ConstraintLayout constraintId1
        , android.widget.ImageView dividerAddress1
        , android.widget.ImageView dividerDetails1
        , com.ramotion.foldingcell.FoldingCell exTravel1
        , android.widget.ImageView imageMap1
        , android.widget.TextView labelCost1
        , android.widget.TextView labelDetailsCost1
        , android.widget.TextView labelDetailsDistance1
        , android.widget.TextView labelDistance1
        , android.widget.TextView labelDuration1
        , android.widget.TextView labelFinishTime1
        , android.widget.TextView labelFrom1
        , android.widget.TextView labelRequestTime1
        , android.widget.TextView labelTo1
        , android.widget.TextView textCost1
        , android.widget.TextView textDetailsCost1
        , android.widget.TextView textDetailsDistance1
        , android.widget.TextView textDistance1
        , android.widget.TextView textDuration1
        , android.widget.TextView textFinishDate1
        , android.widget.TextView textFinishTime1
        , android.widget.TextView textFrom1
        , android.widget.TextView textRequestDate1
        , android.widget.TextView textRequestTime1
        , android.widget.TextView textStatus1
        , android.widget.TextView textTo1
        , android.widget.TextView titleDateLabel1
        , android.widget.TextView titleFromAddress1
        , android.widget.ImageView titleFromToDots1
        , android.widget.ImageView titleFromToDotsDivider1
        , android.widget.TextView titleId1
        , android.widget.TextView titleTimeLabel1
        , android.widget.TextView titleToAddress1
    ) {
        super(bindingComponent, root_, localFieldCount);
        this.buttonComplaint = buttonComplaint1;
        this.buttonHideTravel = buttonHideTravel1;
        this.cellContentView = cellContentView1;
        this.cellTitleView = cellTitleView1;
        this.constraintContent = constraintContent1;
        this.constraintHeader = constraintHeader1;
        this.constraintId = constraintId1;
        this.dividerAddress = dividerAddress1;
        this.dividerDetails = dividerDetails1;
        this.exTravel = exTravel1;
        this.imageMap = imageMap1;
        this.labelCost = labelCost1;
        this.labelDetailsCost = labelDetailsCost1;
        this.labelDetailsDistance = labelDetailsDistance1;
        this.labelDistance = labelDistance1;
        this.labelDuration = labelDuration1;
        this.labelFinishTime = labelFinishTime1;
        this.labelFrom = labelFrom1;
        this.labelRequestTime = labelRequestTime1;
        this.labelTo = labelTo1;
        this.textCost = textCost1;
        this.textDetailsCost = textDetailsCost1;
        this.textDetailsDistance = textDetailsDistance1;
        this.textDistance = textDistance1;
        this.textDuration = textDuration1;
        this.textFinishDate = textFinishDate1;
        this.textFinishTime = textFinishTime1;
        this.textFrom = textFrom1;
        this.textRequestDate = textRequestDate1;
        this.textRequestTime = textRequestTime1;
        this.textStatus = textStatus1;
        this.textTo = textTo1;
        this.titleDateLabel = titleDateLabel1;
        this.titleFromAddress = titleFromAddress1;
        this.titleFromToDots = titleFromToDots1;
        this.titleFromToDotsDivider = titleFromToDotsDivider1;
        this.titleId = titleId1;
        this.titleTimeLabel = titleTimeLabel1;
        this.titleToAddress = titleToAddress1;
    }
    //getters and abstract setters
    public abstract void setItem(@Nullable com.innomalist.taxi.common.models.Travel Item);
    @Nullable
    public com.innomalist.taxi.common.models.Travel getItem() {
        return mItem;
    }
    @NonNull
    public static ItemTravelBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemTravelBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemTravelBinding bind(@NonNull android.view.View view) {
        return null;
    }
    @NonNull
    public static ItemTravelBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return null;
    }
    @NonNull
    public static ItemTravelBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return null;
    }
    @NonNull
    public static ItemTravelBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return null;
    }
}