package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DayNinteen {

    public static void main(String [] args){
        FileHelper fh = new FileHelper("2020/DayNinteen.txt");
        List<String> data = fh.getFileAsList();
        HashMap<Integer, String> rules = null;
        List<String> inputData = new ArrayList<>();
        List<String> testData = new ArrayList<>();


        rules = loadRules(data);
        testData = loadTests(data);

        List<String> matches = matchRule(0,rules);
        int count = 0;
        for (String test: testData){
            if (matches.contains(test)){
                count++;
            }
        }
        System.out.println("Part 1 : " + count);

    }

    public static List<String> loadTests(List<String> data){
        List<String> results = new ArrayList<String>();
        boolean inData = false;
        for (String line: data){
            if (line.isEmpty()){
                inData = true;
                continue;
            }
            if (inData == true){
                results.add(line);
            }


        }
        return results;
    }
    public static HashMap<Integer, String>  loadRules(List<String> data) {
        HashMap<Integer, String> results = new HashMap<Integer, String>();
        boolean loadRules = true;
        for (String line: data){
            if (line.isEmpty()) {
                loadRules =false;
                break;
            }
            if (loadRules ==true) {
                String[] parts = line.split(": ");
                int i = Integer.parseInt(parts[0]);
                results.put(i, parts[1]);
            }
        }
        return results;
    }

    //0: 1 2
    //1: "a"
    //2: 1 3 | 3 1
    //3: "b"
    public static List<String> matchRule(int index,HashMap<Integer,String> rules){

        List <String> results = new ArrayList<>();
        String rule = rules.get(index);
        char c = rule.charAt(1);

        // If we have found a character this terminates the recursion.
        if (Character.isLetter(c)) {
            results.add(c + "");
            return results;
        }
        String[] pairOfRules = rule.split(" \\| ");

        for (String s: pairOfRules){
            List<List<String>> children = new ArrayList<>();

            String [] matchingRuleArray = s.split(" ");
            for (String matchingRule: matchingRuleArray){
                children.add(matchRule(Integer.parseInt(matchingRule),rules));
            }
            if (children.size() == 1){
                results.addAll(children.get(0));
            }
            else if (children.size() == 2){
                for (int i = 0; i < children.get(0).size(); i++){
                    for (int j = 0; j < children.get(1).size(); j++){
                        results.add(children.get(0).get(i) + children.get(1).get(j));
                    }
                }
            }
            else if (children.size() == 3){
                for (int i = 0; i < children.get(0).size(); i++){
                    for (int j = 0; j < children.get(1).size(); j++){
                        for (int k = 0; k < children.get(2).size(); k++) {
                            results.add(children.get(0).get(i) + children.get(1).get(j) + children.get(2).get(k));
                        }
                    }
                }
            }
        }
        return results;
    }

}
