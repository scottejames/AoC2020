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
            int i = history[last];
            int n = 0;
            if (i == 0) n = 0;
            else  n = turn - i - 1;
            history[last] = turn++ -1;
            last = n;
        }
        System.out.println(last);
    }
}
