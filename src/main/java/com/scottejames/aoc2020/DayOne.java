package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;

import java.util.List;

public class DayOne {

    public  static void main(String [] args) {
        FileHelper fh = new FileHelper("2020/DayOne.txt");
        List<Integer> data = fh.getFileAsIntegerList();

        int x = 0;
        int y = 0;
        int z = 0;
        int result = 0;
        for (x = 0; x < data.size();x ++)
            for (y = 0; y < data.size();y++)
                for (z = 0;z < data.size();z++){
//                System.out.println("Matching " + data.get(x) + " - " + data.get(y));
                if (data.get(x) + data.get(y) + data.get(z) == 2020) {
                    result = data.get(x) * data.get(y)* data.get(z);
                }
            }

        System.out.println("Result is " + result);
    }
}
