package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;
import com.scottejames.utils.Range;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayFive {
    public enum PartitionDirection { UP, DOWN};

    private static final int MAX_ROW=127;

    public static void main(String [] args){
        FileHelper fh = new FileHelper("2020/DayFive.txt");
        List<Integer> foundSeats = new ArrayList();
        List<String> data = fh.getFileAsList();
        int max = 0;
        for (String line : data){
            int seatNumber = getSeatNumber(line);
            foundSeats.add(seatNumber);
            if (seatNumber > max) max = seatNumber;
        }
        System.out.println("Max seat " + max);
        Collections.sort(foundSeats);
        for (int i = 1;i < foundSeats.size(); i++){
            if (foundSeats.get(i) != foundSeats.get(i-1) + 1){
                int result = foundSeats.get(i) - 1;
                System.out.println("My seat " + result);
            }
        }
    }
    public static Range partition(Range r, PartitionDirection direction ){

        int increment = ((r.max-r.min) / 2) +1;
        if (direction == PartitionDirection.UP){
            r.min += increment;
        } else {
            r.max -= increment;
        }
        return r;
    }
    public static int getRow(String key) {
        Range r = new Range(0,127);
        for (int i = 0; i < 7;i++) {
            char c = key.charAt(i);
            PartitionDirection direction = c=='F'?PartitionDirection.DOWN:PartitionDirection.UP;
            r = partition(r, direction);
        }
        return r.min;
    }

    public static int getColumn(String key) {
        Range r = new Range(0,7);
        for (int i = 0; i < 3;i++){
            char c = key.charAt(i);
            PartitionDirection direction = c=='L'?PartitionDirection.DOWN:PartitionDirection.UP;
            r = partition(r,direction);
        }
        return r.min;
    }

    public static int getSeatNumber(String key){
        String row = key.substring(0,7);
        String column = key.substring(7,10);
        int rowNumber = getRow(row);
        int columnNumber = getColumn(column);

        return (rowNumber * 8) + columnNumber;
    }




}
