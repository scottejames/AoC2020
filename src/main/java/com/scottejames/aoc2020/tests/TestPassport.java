package com.scottejames.aoc2020.tests;

import com.scottejames.aoc2020.Passport;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestPassport {

    @Test
    public void testLoadPassport(){
        String passport = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm";

        Passport p = new Passport(passport);
        String birthYear = p.getBirthYear();
        int length = birthYear.length();
        assertTrue(length > 0);
        assertTrue(birthYear.equals("1937"));
    }
    //byr (Birth Year)
    //iyr (Issue Year)
    //eyr (Expiration Year)
    //hgt (Height)
    //hcl (Hair Color)
    //ecl (Eye Color)
    //pid (Passport ID)
    //cid (Country ID)
    @Test
    public void testAllFieldsPassport() {
        String passport = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm";

        Passport p = new Passport(passport);
        String birthYear = p.getBirthYear();
        String issueYear = p.getIssueYear();
        String expYear = p.getExperationYear();
        String height = p.getHeight();
        String hairColour = p.getHairColour();
        String eyeColour = p.getEyeColour();
        String passportID = p.getPassportID();
        String countryId = p.getCountryID();

        assertTrue(birthYear.length() > 0);
        assertTrue(issueYear.length() > 0);
        assertTrue(expYear.length() > 0);
        assertTrue(height.length() > 0);
        assertTrue(hairColour.length() > 0);
        assertTrue(eyeColour.length() > 0);
        assertTrue(passportID.length() > 0);
        assertTrue(countryId.length() > 0);
    }
    @Test
    public void testMissingFieldsPassport() {
        String passport = "pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm";

        Passport p = new Passport(passport);
        String eyeColour = p.getEyeColour();
        String hairColour = p.getHairColour();

        assertTrue(hairColour.length() > 0);
        assertTrue(eyeColour == null);
    }

    @Test
    public void testValidPassportOne(){
        String passport = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm";
        Passport p = new Passport(passport);
        assertTrue(p.isComplete());

    }

    @Test
    public void testValidPassportTwo(){
        String passport = "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929";

        Passport p = new Passport(passport);
        assertFalse(p.isComplete());

    }

    @Test
    public void testValidPassportThree(){
        String passport = "hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm";
        Passport p = new Passport(passport);
        assertTrue(p.isComplete());
    }

    @Test
    public void testValidPassportFour(){
        String passport = "hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in";
        Passport p = new Passport(passport);
        assertFalse(p.isComplete());
    }
    @Test
    public void testValidBirthYear(){
        String valid = "2002";
        String invalid = "2003";
        String passport = "hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in";

        Passport p = new Passport(passport);

        assertTrue(p.isBirthYearValid(valid));
        assertFalse(p.isBirthYearValid(invalid));
    }

    @Test
    public void testValidHeight(){
        String validOne = "60in";
        String validTwo = "190cm";
        String invalidOne = "190in";
        String invalidTwo = "190";
        String passport = "hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in";

        Passport p = new Passport(passport);
        assertTrue(p.isHeightValid(validOne));
        assertTrue(p.isHeightValid(validTwo));
        assertFalse(p.isHeightValid(invalidOne));
        assertFalse(p.isHeightValid(invalidTwo));
    }

    @Test
    public void testValidHairColour(){
        String validOne = "#123abc";
        String invalidOne = "#123abz";
        String invalidTwo = "123abc";
        String passport = "hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in";

        Passport p = new Passport(passport);

        assertTrue(p.isHairColourValid(validOne));
        assertFalse(p.isHairColourValid(invalidOne));
        assertFalse(p.isHairColourValid(invalidTwo));
    }

    @Test
    public void testValidEyeColour(){
        String validOne = "brn";
        String invalidOne = "wat";

        String passport = "hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in";

        Passport p = new Passport(passport);

        assertTrue(p.isEyeColourValid(validOne));
        assertFalse(p.isEyeColourValid(invalidOne));
    }

    @Test
    public void testPassportId(){
        String validOne = "000000001";
        String invalidOne = "0123456789";
        String passport = "hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in";

        Passport p = new Passport(passport);

        assertTrue(p.isPassportIDValid(validOne));
        assertFalse(p.isPassportIDValid(invalidOne));
    }

    @Test
    public void testValidPassport(){
        String passport = "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980 hcl:#623a2f";
        Passport p = new Passport(passport);
        assertTrue(p.isValid());
    }
    @Test
    public void testInValidPassport(){
        String passport = "eyr:1972 cid:100 hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926";
        Passport p = new Passport(passport);
        assertFalse(p.isValid());
    }
}
