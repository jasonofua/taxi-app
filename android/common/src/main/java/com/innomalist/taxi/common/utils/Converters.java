package com.innomalist.taxi.common.utils;

import android.databinding.InverseMethod;

public class Converters {

    public static boolean genderIsMale(String gender) {
        return gender.equals("male");
    }

    @InverseMethod("genderIsMale")
    public static String genderFromIsMale(boolean isMale) {
        return isMale ? "male" : "female";
    }
}
