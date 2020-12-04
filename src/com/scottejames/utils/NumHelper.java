package com.scottejames.utils;

import static java.lang.Integer.parseInt;

public class NumHelper {
    public static boolean isValidNumber(int num, int min, int max) {
        return num >= min && num <= max;
    }

    public static boolean isValidNumber(String str, int min, int max) {
        if (str == null) return false;
        int num = parseInt(str);
        return num >= min && num <= max;
    }
    public static boolean isValidNumber(String str){

        try {
            parseInt(str);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
    public static boolean isValidLong(String str){

        try {
            Long.parseLong(str, 16);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

}
