package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayTwo {

    public static void main(String [] args) {
        FileHelper fh = new FileHelper("2020/DayTwo.txt");
        List<String> data = fh.getFileAsList();

       int count = 0;
       for(String password: data){
           if (validate(password)){
               count++;
           }
       }
       System.out.println("There are " + count + " valid passwords");

    }

    public static boolean validate(String data) {
        String subject = data;

        Pattern pattern = Pattern.compile("(\\d+)-(\\d+)\\s([a-z]):\\s([a-z]+)");
        Matcher match = pattern.matcher(subject);
        match.find();

        Integer from = Integer.parseInt(match.group(1));
        Integer to = Integer.parseInt(match.group(2));
        char c = match.group(3).charAt(0);
        String password = match.group(4);

        char destinationOne = password.charAt(from-1);
        char destinationTwo = password.charAt(to-1);

        if (destinationOne == destinationTwo){
            return false;
        }
        if ((destinationOne == c) || (destinationTwo == c)){
            return true;
        } else {
            return false;
        }
//
//        int count = FileHelper.countChar(c, password);
//
//        if ((count >= from) && (count <= to)) {
//              return true;
//        } else {
//            return false;
//
//        }

    }
}
