package com.scottejames.aoc2020;

import com.scottejames.utils.CircularBuffer;

import java.util.HashMap;
import java.util.Map;

public class DayTwentyThree {

    public static void main(String [] args) {
        String input = "157623984";

        CircularBuffer<Integer> buffer = null;
        Map<Integer, CircularBuffer<Integer>> cups = new HashMap<>();
        int maxVal = 0;
        for (char c : input.toCharArray()) {

            int value = Integer.parseInt(c + "");

            if (value > maxVal) maxVal = value;
            CircularBuffer<Integer> newElement = new CircularBuffer<>(value);
            cups.put(value, newElement);

            if (buffer != null) {
                buffer.insertAfter(newElement);
            }
            buffer = newElement;
        }
        for (int value = input.length()+1; value <= 1_000_000; value++) {
            if (value > maxVal) maxVal = value;

            CircularBuffer<Integer> n = new CircularBuffer<>(value);
            buffer.insertAfter(n);
            buffer = n;
            cups.put(value, n);
        }
//        System.out.println(buffer);
//        System.out.println(cups);

        Integer current = buffer.forward(1).value;

        for (int i = 0; i < 10_000_000; i++){
//            System.out.println("i " + i);
            CircularBuffer<Integer> ccup = cups.get(current);
            CircularBuffer<Integer> firstCup    = ccup.next.remove();
            CircularBuffer<Integer> secondCup   = ccup.next.remove();
            CircularBuffer<Integer> thirdCup    = ccup.next.remove();

            int dest = current - 1;
            if (dest < 1) { dest = maxVal; }
            CircularBuffer<Integer> destinationCup = cups.get(dest);
            while (destinationCup   == firstCup ||
                    destinationCup  == secondCup ||
                    destinationCup  == thirdCup) {
                dest = dest - 1;
                if (dest < 1) { dest = maxVal; }

                destinationCup = cups.get(dest);
            }
            destinationCup.insertAfter(thirdCup);
            destinationCup.insertAfter(secondCup);
            destinationCup.insertAfter(firstCup);
            current = ccup.next.value;
        }
        CircularBuffer<Integer> result = cups.get(1).next;
     //   System.out.println(result);
//        StringBuffer partOne = new StringBuffer();
//        while (!result.value.equals(1)) {
//            partOne.append(result.value);
//            result = result.forward(1);
//        }
//        System.out.println(partOne.toString());
        long a = result.value;
        long b = result.next.value;
        System.out.println(a * b);


    }
}
