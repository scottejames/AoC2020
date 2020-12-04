package com.scottejames.aoc2020;

import com.scottejames.utils.NumHelper;
import com.scottejames.utils.StringHelper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Passport {
    //amb blu brn gry grn hzl oth.
    private static Set<String> VALID_EYE_COLOUR = new HashSet<String>() {{
        add("amb");
        add("blu");
        add("brn");
        add("gry");
        add("grn");
        add("hzl");
        add("oth");
    }};
    private static final String BYR="byr";
    private static final String IYR="iyr";
    private static final String EYR="eyr";
    private static final String HGT="hgt";
    private static final String HCL="hcl";
    private static final String ECL="ecl";
    private static final String PID="pid";
    private static final String CID="cid";

    private final String sourceData;
    private HashMap<String, String> hash = new HashMap();
//        String passport = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm";

    public Passport(String sourceData){
        this.sourceData = sourceData;
        String [] split = sourceData.split(" ");
        for (String s : split){
            if (s.length() > 0) {
                String[] entry = s.split(":");
                hash.put(entry[0], entry[1]);
            }
        }
    }

    public String getBirthYear(){
        String byr = hash.get(BYR);
        return byr;
    }
    public boolean isBirthYearValid(  String byr){
        // byr (Birth Year) - four digits; at least 1920 and at most 2002.

        return NumHelper.isValidNumber(byr,1920,2002);
    }
    public String getIssueYear(){
        String iyr = hash.get(IYR);
        return iyr;
    }

    public boolean isIssueYearValid(String iyr){
        // iyr (Issue Year) - four digits; at least 2010 and at most 2020.

        return NumHelper.isValidNumber(iyr,2010,2020);

    }
    public String getExperationYear(){
        String eyr = hash.get(EYR);
        return eyr;
    }

    public boolean isExperationyearValid(String eyr){
        //eyr (Expiration Year) - four digits; at least 2020 and at most 2030.

        return NumHelper.isValidNumber(eyr,2020,2030);
    }
    public String getHeight(){
        String hgt = hash.get(HGT);
        return hgt;
    }
    public boolean isHeightValid(   String hgt){

        //hgt (Height) - a number followed by either cm or in:
        //If cm, the number must be at least 150 and at most 193.
        //If in, the number must be at least 59 and at most 76.
        if (hgt.contains("cm")) {
            return NumHelper.isValidNumber(hgt.replace("cm", ""),150,193);
        }
        if (hgt.contains("in")) {
            return NumHelper.isValidNumber(hgt.replace("in", ""),59,76);
        }
        return false;

    }
    public String getHairColour(){
        String hcl = hash.get(HCL);
        return hcl;
    }
    public boolean isHairColourValid( String hcl){
        // hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.

        if(hcl.length() != 7 || hcl.charAt(0) != '#') {
            return false;
        }
        if(NumHelper.isValidLong(hcl.substring(1)) == false){
            return false;
        }
        return true;
    }
    public String getEyeColour(){
        String ecl = hash.get(ECL);
        return ecl;
    }

    public boolean isEyeColourValid(String ecl){

        if (VALID_EYE_COLOUR.contains(ecl)) return true;
        else return false;

    }
    public String getPassportID(){
        String pid = hash.get(PID);
        return pid;
    }

    public boolean isPassportIDValid(String pid){
        //pid (Passport ID) - a nine-digit number, including leading zeroes.
        if (pid.length() != 9) return false;
        if (NumHelper.isValidNumber(pid) == false) return false;
        return true;
    }

    public String getCountryID(){
        String cid = hash.get(CID);
        return cid;
    }
    public boolean isComplete(){
        String birthYear = getBirthYear();
        String issueYear = getIssueYear();
        String expYear = getExperationYear();
        String height = getHeight();
        String hairColour = getHairColour();
        String eyeColour = getEyeColour();
        String passportID = getPassportID();
        String countryId = getCountryID();
        if ((birthYear != null) && (issueYear != null) && (expYear != null) && (height !=null) && (hairColour != null) &&
                (eyeColour != null) && (passportID != null)){
            return true;
        } else {
            return false;
        }
    }

    public boolean isValid(){
        String birthYear = getBirthYear();
        String issueYear = getIssueYear();
        String expYear = getExperationYear();
        String height = getHeight();
        String hairColour = getHairColour();
        String eyeColour = getEyeColour();
        String passportID = getPassportID();
        String countryId = getCountryID();

        if (false == ((birthYear != null) && (issueYear != null) && (expYear != null) && (height !=null) && (hairColour != null) &&
                (eyeColour != null) && (passportID != null))){
            return false;
        }
        boolean a= isBirthYearValid(birthYear);
        boolean b= isIssueYearValid(issueYear);
        boolean c= isExperationyearValid(expYear);
        boolean d= isHeightValid(height);
        boolean e= isHairColourValid(hairColour);
        boolean f= isEyeColourValid(eyeColour);
        boolean g= isPassportIDValid(passportID);

        return a && b && c && d && e && f && g;


    }




}
