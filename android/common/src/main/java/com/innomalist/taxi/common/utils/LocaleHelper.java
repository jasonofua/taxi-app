package com.innomalist.taxi.common.utils;

import android.support.v4.text.TextUtilsCompat;
import android.support.v4.view.ViewCompat;

import java.util.Locale;

class LocaleHelper {
    static boolean isRTL(Locale locale) {
        //return ViewUtils.isLayoutRtl(view);
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == ViewCompat.LAYOUT_DIRECTION_RTL;
    }

}
