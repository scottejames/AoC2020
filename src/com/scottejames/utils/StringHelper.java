package com.scottejames.utils;

public class StringHelper {

    public static boolean containsLettersAndNumbers(String str){
        boolean result = true;
        for (int i = 0; i < str.length(); i++){
            if (Character.isLetterOrDigit(str.charAt(i))==false)
                result = false;
        }
        return result;

    }

    public static long countCharInString(char c, String s){
        return  s.chars().filter(ch -> ch == c).count();

    }


}
