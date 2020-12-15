package com.scottejames.aoc2020;

public class DayFifteen {

    public static void main(String [] args){
        int[] inputData = {9,6,0,10,18,2,1};
        int target = 30000000;

        int[] history = new int[target];
        int turn = 1;
        int last = 0;
        for (int i : inputData){
            history[i] = turn++;
            last = i;
        }

        while (turn <= target) {
            int lastSeen = history[last];
            int speak = 0;
            if (lastSeen == 0) speak = 0;
            else  speak = turn - lastSeen - 1;
            history[last] = turn -1;
            turn++;
            last = speak;
        }
        System.out.println(last);
    }
}
