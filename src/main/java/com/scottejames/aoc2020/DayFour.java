package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;

public class DayFour {

    public static void main(String [] args){
        FileHelper fh = new FileHelper("2020/DayFour.txt");
        StringBuffer passport = new StringBuffer();
        int passportCount = 0;
        for (String line : fh.getFileAsList()){
            if (line.isEmpty()){

               Passport p = new Passport(passport.toString());
               if (p.isComplete()){
                   passportCount++;
               }
               passport = new StringBuffer();
            } else{
                passport.append(" " + line);
            }
        }
        System.out.println("Thre are " + passportCount + " complete passports");
        passportCount = 0;
        for (String line : fh.getFileAsList()){
            if (line.isEmpty()){

                Passport p = new Passport(passport.toString());
                if (p.isValid()){
                    passportCount++;
                }
                passport = new StringBuffer();
            } else{
                passport.append(" " + line);
            }
        }
        System.out.println("Thre are " + passportCount + " valid passports");
    }

}
