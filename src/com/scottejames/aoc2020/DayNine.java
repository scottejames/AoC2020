package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;
import com.scottejames.utils.Pair;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DayNine {

    public static int PREAMBLE_SIZE = 25;

    public static void main(String[] args) {
        FileHelper fh = new FileHelper("2020/DayNine.txt");

        List<Long> data = fh.getFileAsList().stream().map(Long::parseLong).collect(toList());
        List<Long> results = new ArrayList<>();

        for (int i = 0; i < data.size() - PREAMBLE_SIZE; i++) {
            Long test = data.get(i + PREAMBLE_SIZE);

            List<Long> preamble = data.subList(i, i + PREAMBLE_SIZE);

            if (checkIfPossibleSumInArray(preamble,test)==false){
                results.add(test);
            }
        }
        System.out.println(results);
        var result = findSumRange(data,15353384);
        System.out.println(result);
    }

    public static boolean checkIfPossibleSumInArray(List<Long> array, long numberToCheck) {
        for (int x = 0; x < array.size() - 1; x++) {
            for (int y = x + 1; y < array.size(); y++) {
                if (array.get(x) + array.get(y) == numberToCheck) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<Pair<Long,Long>> findSumRange(List<Long> data,int target) {
        List<Pair<Long, Long>> result = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            int j = i;
            long sum = 0;
            long min = Long.MAX_VALUE;
            long max = 0;
            while (sum < target) {
                long incr = data.get(j);
                if (incr < min) min = incr;
                if (incr > max) max = incr;
                sum += incr;
                j++;
            }
            if (sum == target) {
                result.add(new Pair<Long,Long>(min, max));
            }
        }
        return result;
    }
}