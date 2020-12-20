package com.scottejames.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static Set<Character> stringToCharSet(String s){
        Set<Character> result = new HashSet<>();

        for (char c: s.toCharArray()){
            result.add(c);
        }
        return result;
    }

    // takes string NUM-NUM and returns a pair of nums
    //        Pattern pattern = Pattern.compile("(.*) bags contain (.*)$");
    //        Pattern embeddedPattern = Pattern.compile("([1-9]+) ([a-z ]+) bag");
    //        Matcher match = pattern.matcher(line);
    //        match.find();
    //        String bagColour = match.group(1);
    public static Pair<Integer, Integer> splitRangeToPair(String range){
        Pattern p = Pattern.compile(" ?([0-9]+)-([0-9]+) ?");
        Matcher m = p.matcher(range);
        m.find();

        Integer lhs = Integer.parseInt(m.group(1));
        Integer rhs = Integer.parseInt(m.group(2));
        return new Pair(lhs,rhs);
    }


    public static String reverse(String str) {
        return new StringBuffer(str).reverse().toString();
    }
    public static String toBinary(int x, int len) {

        if (len > 0) {
            return String.format("%" + len + "s",
                    Integer.toBinaryString(x)).replaceAll(" ", "0");
        }

        return null;
    }

}
