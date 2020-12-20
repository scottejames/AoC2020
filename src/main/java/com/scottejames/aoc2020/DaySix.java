package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;
import com.scottejames.utils.StringHelper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DaySix {

    public static void main(String [] args){
        FileHelper fh = new FileHelper("2020/DaySix.txt");
        List<String> data = fh.getFileAsList();
        StringBuffer answers = new StringBuffer();
        int resultA = 0;
        int resultB = 0;
        int groupSize = 0;
        for (String line : fh.getFileAsList()){
            if (line.isEmpty()){
                int countA = calculateSet(answers.toString());
                int countB = calculateUniqueAnswers(answers.toString(),groupSize);
                resultA += countA;
                resultB += countB;
                groupSize=0;
                answers = new StringBuffer();
            }else{
                groupSize++;
                answers.append(line);
            }

        }
        System.out.println(resultA + " / " + resultB);

    }

    private static int calculateSet(String set) {
        Set result = new HashSet<Character>();

        for (char c: set.toCharArray()){
            result.add(c);
        }
        return result.size();
    }
    private static int calculateUniqueAnswers(String set, int groupSize){
        Set<Character> setSet = new HashSet<Character>();
        int result = 0;
        for (char c: set.toCharArray()){
            setSet.add(c);
        }
        for (Character c: setSet){
            long count = StringHelper.countCharInString(c,set);
            if (count == groupSize){
                result ++;
            }
        }
        return result;
    }
}
