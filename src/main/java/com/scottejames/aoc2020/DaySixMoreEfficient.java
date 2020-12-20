package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;
import com.scottejames.utils.StringHelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DaySixMoreEfficient {

    public static void main(String [] args) {
        FileHelper fh = new FileHelper("2020/DaySix.txt");
        List<String> data = fh.getFileAsList();
        List<Set> group = new ArrayList<Set>();

        int unionSum = 0;
        int intersectSum = 0;

        for (String line: data) {
            if (line.isEmpty()){
                unionSum += computeUnion(group);
                intersectSum  += computeIntersection(group);
                group = new ArrayList<Set>();;
            } else {
                group.add(StringHelper.stringToCharSet(line));
            }
        }
        System.out.println("UnionSum " + unionSum + " IntersectSum " + intersectSum);
    }

    private static int computeUnion(List<Set> group) {
        Set<Character> result = new HashSet<>();
        for (Set i : group){
            result.addAll(i);
        }
        return result.size();
    }

    private static int computeIntersection(List<Set> group) {
        Set<Character> result = new HashSet<>();
        result.addAll(group.get(0));
        for (Set i : group){
            result.retainAll(i);
        }

        return result.size();
    }

}

