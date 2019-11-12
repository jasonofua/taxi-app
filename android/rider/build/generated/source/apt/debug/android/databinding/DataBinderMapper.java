
package android.databinding;
import com.innomalist.taxi.rider.BR;
@javax.annotation.Generated("Android Data Binding")
class DataBinderMapper  {
    final static int TARGET_MIN_SDK = 16;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.innomalist.taxi.rider.R.layout.card_driver_type:
                    return com.innomalist.taxi.rider.databinding.CardDriverTypeBinding.bind(view, bindingComponent);
                case com.innomalist.taxi.rider.R.layout.activity_edit_profile:
                    return com.innomalist.taxi.rider.databinding.ActivityEditProfileBinding.bind(view, bindingComponent);
                case com.innomalist.taxi.rider.R.layout.item_service:
                    return com.innomalist.taxi.rider.databinding.ItemServiceBinding.bind(view, bindingComponent);
                case com.innomalist.taxi.rider.R.layout.item_address:
                    return com.innomalist.taxi.rider.databinding.ItemAddressBinding.bind(view, bindingComponent);
                case com.innomalist.taxi.common.R.layout.activity_charge_account:
                    return com.innomalist.taxi.common.databinding.ActivityChargeAccountBinding.bind(view, bindingComponent);
                case com.innomalist.taxi.common.R.layout.item_travel:
                    return com.innomalist.taxi.common.databinding.ItemTravelBinding.bind(view, bindingComponent);
                case com.innomalist.taxi.rider.R.layout.card_driver_info:
                    return com.innomalist.taxi.rider.databinding.CardDriverInfoBinding.bind(view, bindingComponent);
                case com.innomalist.taxi.common.R.layout.activity_login:
                    return com.innomalist.taxi.common.databinding.ActivityLoginBinding.bind(view, bindingComponent);
                case com.innomalist.taxi.rider.R.layout.fragment_review:
                    return com.innomalist.taxi.rider.databinding.FragmentReviewBinding.bind(view, bindingComponent);
                case com.innomalist.taxi.rider.R.layout.fragment_edit_address:
                    return com.innomalist.taxi.rider.databinding.FragmentEditAddressBinding.bind(view, bindingComponent);
                case com.innomalist.taxi.rider.R.layout.activity_addresses:
                    return com.innomalist.taxi.rider.databinding.ActivityAddressesBinding.bind(view, bindingComponent);
                case com.innomalist.taxi.rider.R.layout.activity_main:
                    return com.innomalist.taxi.rider.databinding.ActivityMainBinding.bind(view, bindingComponent);
                case com.innomalist.taxi.rider.R.layout.card_driver_accepted:
                    return com.innomalist.taxi.rider.databinding.CardDriverAcceptedBinding.bind(view, bindingComponent);
                case com.innomalist.taxi.rider.R.layout.dialog_request_service:
                    return com.innomalist.taxi.rider.databinding.DialogRequestServiceBinding.bind(view, bindingComponent);
                case com.innomalist.taxi.rider.R.layout.activity_travel:
                    return com.innomalist.taxi.rider.databinding.ActivityTravelBinding.bind(view, bindingComponent);
                case com.innomalist.taxi.rider.R.layout.activity_splash:
                    return com.innomalist.taxi.rider.databinding.ActivitySplashBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case -2044653448: {
                if(tag.equals("layout/card_driver_type_0")) {
                    return com.innomalist.taxi.rider.R.layout.card_driver_type;
                }
                break;
            }
            case -1158109584: {
                if(tag.equals("layout/activity_edit_profile_0")) {
                    return com.innomalist.taxi.rider.R.layout.activity_edit_profile;
                }
                break;
            }
            case -635338625: {
                if(tag.equals("layout/item_service_0")) {
                    return com.innomalist.taxi.rider.R.layout.item_service;
                }
                break;
            }
            case 433390078: {
                if(tag.equals("layout/item_address_0")) {
                    return com.innomalist.taxi.rider.R.layout.item_address;
                }
                break;
            }
            case -1018865826: {
                if(tag.equals("layout/activity_charge_account_0")) {
                    return com.innomalist.taxi.common.R.layout.activity_charge_account;
                }
                break;
            }
            case 857986514: {
                if(tag.equals("layout/item_travel_0")) {
                    return com.innomalist.taxi.common.R.layout.item_travel;
                }
                break;
            }
            case 1924946156: {
                if(tag.equals("layout/card_driver_info_0")) {
                    return com.innomalist.taxi.rider.R.layout.card_driver_info;
                }
                break;
            }
            case -237232145: {
                if(tag.equals("layout/activity_login_0")) {
                    return com.innomalist.taxi.common.R.layout.activity_login;
                }
                break;
            }
            case 1496399475: {
                if(tag.equals("layout/fragment_review_0")) {
                    return com.innomalist.taxi.rider.R.layout.fragment_review;
                }
                break;
            }
            case 672979098: {
                if(tag.equals("layout/fragment_edit_address_0")) {
                    return com.innomalist.taxi.rider.R.layout.fragment_edit_address;
                }
                break;
            }
            case -1259933848: {
                if(tag.equals("layout/activity_addresses_0")) {
                    return com.innomalist.taxi.rider.R.layout.activity_addresses;
                }
                break;
            }
            case 423753077: {
                if(tag.equals("layout/activity_main_0")) {
                    return com.innomalist.taxi.rider.R.layout.activity_main;
                }
                break;
            }
            case 1893722917: {
                if(tag.equals("layout/card_driver_accepted_0")) {
                    return com.innomalist.taxi.rider.R.layout.card_driver_accepted;
                }
                break;
            }
            case 195334020: {
                if(tag.equals("layout/dialog_request_service_0")) {
                    return com.innomalist.taxi.rider.R.layout.dialog_request_service;
                }
                break;
            }
            case 500839382: {
                if(tag.equals("layout/activity_travel_0")) {
                    return com.innomalist.taxi.rider.R.layout.activity_travel;
                }
                break;
            }
            case 1573928931: {
                if(tag.equals("layout/activity_splash_0")) {
                    return com.innomalist.taxi.rider.R.layout.activity_splash;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"address"
            ,"carMedia"
            ,"converter"
            ,"driver"
            ,"driverType"
            ,"email"
            ,"firstName"
            ,"gender"
            ,"info"
            ,"item"
            ,"lastName"
            ,"media"
            ,"mobileNumber"
            ,"user"};
    }
}