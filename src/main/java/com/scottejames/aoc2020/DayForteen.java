package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayForteen {

    public static void main(String [] args){

        FileHelper fh = new FileHelper("2020/DayFourteen.txt");
        List<String> data = fh.getFileAsList();
        String[] mask = null;
        Map<Integer, String[]> memory = new HashMap<>();
        Pattern p = Pattern.compile("\\d+");

        for (String line: data) {
            String list[] = line.split(" = ");
            if ("mask".equals(list[0])) {
                mask = list[1].split("");
            } else {
                Matcher m = p.matcher(list[0]);
                m.find();
                int address = Integer.parseInt(m.group());
                memory.put(address, applyMask(mask, Integer.parseInt(list[1])));
            }
        }
        BigInteger result = BigInteger.ZERO;
        for (String[] value: memory.values()){
            String num = joinString(value);
            BigInteger i = new BigInteger(num,2);
            result =    result.add(i);
        }
        System.out.println("Part 1: " + result);

    }
    private static String joinString(String[] data){
        StringBuffer result = new StringBuffer();
        for (String line: data){
            result.append(line);
        }
        return result.toString();
    }
    private static String[] applyMask(String[] mask, int value) {
        String[] binary = String.format("%36s",
                Integer.toBinaryString(value)).
                replace(" ", "0").
                split("");

        for (int i = 0; i < mask.length; i++) {
            if (!"X".equalsIgnoreCase(mask[i])) {
                binary[i] = mask[i];
            }
        }
        return binary;

    }
}
