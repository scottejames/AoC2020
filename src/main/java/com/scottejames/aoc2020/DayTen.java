package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;

import java.util.*;

public class DayTen {

    public static void main(String [] args){

        FileHelper fh = new FileHelper("2020/DayTen.txt");
        List<Integer> data = fh.getFileAsIntegerList();
        System.out.println(partOne(data));
        System.out.println(partTwo(data));

    }

    public static int partOne(List<Integer> data){
        Collections.sort(data);
        Integer max = Collections.max(data);
        data.add(max + 3);

        int threeJolt = 0;
        int oneJolt = 0;
        int prior = 0;
        for (Integer i : data){
            if (i - prior == 1) {
                oneJolt++;
            }
            else if (i - prior == 3){
                threeJolt++;
            }
            prior = i;
        }
        return threeJolt * oneJolt;
    }

    public static long partTwo(List<Integer> data){
        int prev = 0;
        int consecutive = 1;
        long result = 1;

        for(int i : data){
            if (i==prev+1){
                consecutive++;
            } else {
                result *= threeFib(consecutive);
                consecutive=1;
            }
            prev = i;
        }
        return result;
    }
    public static int threeFib(int n){
        if (n<1) return 0;
        if (n==1) return 1;
        if (n==2) return 1;
        if (n==3) return 2;
        return threeFib(n-1) + threeFib(n-2) + threeFib(n-3);
    }

}
