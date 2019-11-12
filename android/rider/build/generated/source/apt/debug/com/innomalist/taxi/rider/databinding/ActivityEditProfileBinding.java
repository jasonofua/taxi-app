package com.innomalist.taxi.rider.databinding;
import com.innomalist.taxi.rider.R;
import com.innomalist.taxi.rider.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityEditProfileBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.app_bar_layout, 8);
        sViewsWithIds.put(R.id.collapse_toolbar, 9);
        sViewsWithIds.put(R.id.media, 10);
        sViewsWithIds.put(R.id.toolbar, 11);
        sViewsWithIds.put(R.id.mobile_text_layout, 12);
        sViewsWithIds.put(R.id.email_text_layout, 13);
        sViewsWithIds.put(R.id.first_name_text_layout, 14);
        sViewsWithIds.put(R.id.last_name_text_layout, 15);
        sViewsWithIds.put(R.id.address_text_layout, 16);
    }
    // views
    @NonNull
    public final android.support.design.widget.TextInputLayout addressTextLayout;
    @NonNull
    public final android.support.design.widget.AppBarLayout appBarLayout;
    @NonNull
    public final android.support.design.widget.CollapsingToolbarLayout collapseToolbar;
    @NonNull
    public final android.support.design.widget.TextInputLayout emailTextLayout;
    @NonNull
    public final android.support.design.widget.TextInputLayout firstNameTextLayout;
    @NonNull
    public final android.support.design.widget.TextInputLayout lastNameTextLayout;
    @NonNull
    private final android.support.design.widget.CoordinatorLayout mboundView0;
    @NonNull
    private final android.widget.EditText mboundView2;
    @NonNull
    private final android.widget.EditText mboundView3;
    @NonNull
    private final android.widget.EditText mboundView4;
    @NonNull
    private final android.widget.EditText mboundView5;
    @NonNull
    private final android.widget.EditText mboundView7;
    @NonNull
    public final android.widget.ImageView media;
    @NonNull
    public final android.support.design.widget.TextInputLayout mobileTextLayout;
    @NonNull
    public final de.hdodenhof.circleimageview.CircleImageView profileImage;
    @NonNull
    public final com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner spinnerGender;
    @NonNull
    public final android.support.v7.widget.Toolbar toolbar;
    // variables
    @Nullable
    private com.innomalist.taxi.common.utils.Converters mConverter;
    @Nullable
    private com.innomalist.taxi.common.models.Rider mUser;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener mboundView3androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of user.email
            //         is user.setEmail((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView3);
            // localize variables for thread safety
            // user.email
            java.lang.String userEmail = null;
            // user != null
            boolean userJavaLangObjectNull = false;
            // user
            com.innomalist.taxi.common.models.Rider user = mUser;



            userJavaLangObjectNull = (user) != (null);
            if (userJavaLangObjectNull) {




                user.setEmail(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView4androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of user.firstName
            //         is user.setFirstName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView4);
            // localize variables for thread safety
            // user != null
            boolean userJavaLangObjectNull = false;
            // user.firstName
            java.lang.String userFirstName = null;
            // user
            com.innomalist.taxi.common.models.Rider user = mUser;



            userJavaLangObjectNull = (user) != (null);
            if (userJavaLangObjectNull) {




                user.setFirstName(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView5androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of user.lastName
            //         is user.setLastName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView5);
            // localize variables for thread safety
            // user != null
            boolean userJavaLangObjectNull = false;
            // user
            com.innomalist.taxi.common.models.Rider user = mUser;
            // user.lastName
            java.lang.String userLastName = null;



            userJavaLangObjectNull = (user) != (null);
            if (userJavaLangObjectNull) {




                user.setLastName(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView7androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of user.address
            //         is user.setAddress((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView7);
            // localize variables for thread safety
            // user.address
            java.lang.String userAddress = null;
            // user != null
            boolean userJavaLangObjectNull = false;
            // user
            com.innomalist.taxi.common.models.Rider user = mUser;



            userJavaLangObjectNull = (user) != (null);
            if (userJavaLangObjectNull) {




                user.setAddress(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private android.databinding.InverseBindingListener spinnerGendergenderAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of user.gender
            //         is user.setGender((com.innomalist.taxi.common.models.Gender) callbackArg_0)
            com.innomalist.taxi.common.models.Gender callbackArg_0 = com.innomalist.taxi.common.utils.DataBinder.getGender(spinnerGender);
            // localize variables for thread safety
            // user != null
            boolean userJavaLangObjectNull = false;
            // user
            com.innomalist.taxi.common.models.Rider user = mUser;
            // user.gender
            com.innomalist.taxi.common.models.Gender userGender = null;



            userJavaLangObjectNull = (user) != (null);
            if (userJavaLangObjectNull) {




                user.setGender(((com.innomalist.taxi.common.models.Gender) (callbackArg_0)));
            }
        }
    };

    public ActivityEditProfileBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds);
        this.addressTextLayout = (android.support.design.widget.TextInputLayout) bindings[16];
        this.appBarLayout = (android.support.design.widget.AppBarLayout) bindings[8];
        this.collapseToolbar = (android.support.design.widget.CollapsingToolbarLayout) bindings[9];
        this.emailTextLayout = (android.support.design.widget.TextInputLayout) bindings[13];
        this.firstNameTextLayout = (android.support.design.widget.TextInputLayout) bindings[14];
        this.lastNameTextLayout = (android.support.design.widget.TextInputLayout) bindings[15];
        this.mboundView0 = (android.support.design.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.EditText) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.EditText) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.EditText) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.EditText) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView7 = (android.widget.EditText) bindings[7];
        this.mboundView7.setTag(null);
        this.media = (android.widget.ImageView) bindings[10];
        this.mobileTextLayout = (android.support.design.widget.TextInputLayout) bindings[12];
        this.profileImage = (de.hdodenhof.circleimageview.CircleImageView) bindings[1];
        this.profileImage.setTag(null);
        this.spinnerGender = (com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner) bindings[6];
        this.spinnerGender.setTag(null);
        this.toolbar = (android.support.v7.widget.Toolbar) bindings[11];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x200L;
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
        if (BR.converter == variableId) {
            setConverter((com.innomalist.taxi.common.utils.Converters) variable);
        }
        else if (BR.user == variableId) {
            setUser((com.innomalist.taxi.common.models.Rider) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setConverter(@Nullable com.innomalist.taxi.common.utils.Converters Converter) {
        this.mConverter = Converter;
    }
    @Nullable
    public com.innomalist.taxi.common.utils.Converters getConverter() {
        return mConverter;
    }
    public void setUser(@Nullable com.innomalist.taxi.common.models.Rider User) {
        updateRegistration(0, User);
        this.mUser = User;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.user);
        super.requestRebind();
    }
    @Nullable
    public com.innomalist.taxi.common.models.Rider getUser() {
        return mUser;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeUser((com.innomalist.taxi.common.models.Rider) object, fieldId);
        }
        return false;
    }
    private boolean onChangeUser(com.innomalist.taxi.common.models.Rider User, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.media) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.mobileNumber) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        else if (fieldId == BR.email) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        else if (fieldId == BR.firstName) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        else if (fieldId == BR.lastName) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        else if (fieldId == BR.gender) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
            }
            return true;
        }
        else if (fieldId == BR.address) {
            synchronized(this) {
                    mDirtyFlags |= 0x100L;
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
        java.lang.String stringValueOfUserMobileNumber = null;
        com.innomalist.taxi.common.models.Gender userGender = null;
        java.lang.String userEmail = null;
        com.innomalist.taxi.common.models.Media userMedia = null;
        java.lang.String userFirstName = null;
        long userMobileNumber = 0L;
        com.innomalist.taxi.common.models.Rider user = mUser;
        java.lang.String userAddress = null;
        java.lang.String userLastName = null;

        if ((dirtyFlags & 0x3fdL) != 0) {


            if ((dirtyFlags & 0x281L) != 0) {

                    if (user != null) {
                        // read user.gender
                        userGender = user.getGender();
                    }
            }
            if ((dirtyFlags & 0x211L) != 0) {

                    if (user != null) {
                        // read user.email
                        userEmail = user.getEmail();
                    }
            }
            if ((dirtyFlags & 0x205L) != 0) {

                    if (user != null) {
                        // read user.media
                        userMedia = user.getMedia();
                    }
            }
            if ((dirtyFlags & 0x221L) != 0) {

                    if (user != null) {
                        // read user.firstName
                        userFirstName = user.getFirstName();
                    }
            }
            if ((dirtyFlags & 0x209L) != 0) {

                    if (user != null) {
                        // read user.mobileNumber
                        userMobileNumber = user.getMobileNumber();
                    }


                    // read String.valueOf(user.mobileNumber)
                    stringValueOfUserMobileNumber = java.lang.String.valueOf(userMobileNumber);
            }
            if ((dirtyFlags & 0x301L) != 0) {

                    if (user != null) {
                        // read user.address
                        userAddress = user.getAddress();
                    }
            }
            if ((dirtyFlags & 0x241L) != 0) {

                    if (user != null) {
                        // read user.lastName
                        userLastName = user.getLastName();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x209L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, stringValueOfUserMobileNumber);
        }
        if ((dirtyFlags & 0x211L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, userEmail);
        }
        if ((dirtyFlags & 0x200L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView3, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView3androidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView4, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView4androidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView5, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView5androidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView7, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView7androidTextAttrChanged);
            com.innomalist.taxi.common.utils.DataBinder.bindGenderChanged(this.spinnerGender, spinnerGendergenderAttrChanged);
        }
        if ((dirtyFlags & 0x221L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, userFirstName);
        }
        if ((dirtyFlags & 0x241L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, userLastName);
        }
        if ((dirtyFlags & 0x301L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, userAddress);
        }
        if ((dirtyFlags & 0x205L) != 0) {
            // api target 1

            com.innomalist.taxi.common.utils.DataBinder.setMedia(this.profileImage, userMedia);
        }
        if ((dirtyFlags & 0x281L) != 0) {
            // api target 1

            com.innomalist.taxi.common.utils.DataBinder.setGender(this.spinnerGender, userGender);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityEditProfileBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityEditProfileBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityEditProfileBinding>inflate(inflater, com.innomalist.taxi.rider.R.layout.activity_edit_profile, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityEditProfileBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityEditProfileBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.innomalist.taxi.rider.R.layout.activity_edit_profile, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityEditProfileBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityEditProfileBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_edit_profile_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityEditProfileBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): user
        flag 1 (0x2L): converter
        flag 2 (0x3L): user.media
        flag 3 (0x4L): user.mobileNumber
        flag 4 (0x5L): user.email
        flag 5 (0x6L): user.firstName
        flag 6 (0x7L): user.lastName
        flag 7 (0x8L): user.gender
        flag 8 (0x9L): user.address
        flag 9 (0xaL): null
    flag mapping end*/
    //end
}