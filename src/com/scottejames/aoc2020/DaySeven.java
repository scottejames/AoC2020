package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DaySeven {

    public static class Bag {

        public String colour;
        public HashMap<String, Integer> containedBags = new HashMap<>();

        Bag(String colour) {
            this.colour = colour;
        }
        public void containsBag(String colour, Integer amount){
            containedBags.put(colour,amount);
        }

    }

    public static void findMatchingBag(List<Bag> bagList, List<Bag> matchedBags, String color){
        for(Bag bag: bagList){
            if (!matchedBags.contains(bag)){
                if (bag.containedBags.containsKey(color)){
                    matchedBags.add(bag);
                    findMatchingBag(bagList,matchedBags,bag.colour);
                }
            }
        }
    }
    public static int countChildrenBags(List<Bag> bagList, String color) {
        int count = 0;
        for (Bag b: bagList){
            if (b.colour.equals(color)) {
                for (String inner: b.containedBags.keySet()){
                    count += b.containedBags.get(inner);
                    count += b.containedBags.get(inner) * countChildrenBags(bagList,inner);
                }
            }
        }
        return count;
    }


    public static void main(String [] args){
        List<Bag> listOfBags = new ArrayList <>();

        FileHelper fh = new FileHelper("2020/DaySeven.txt");
        List<String> data = fh.getFileAsList();

        for (String line: data){
            Bag result = parseInput(line);
            listOfBags.add(result);
        }
        List<Bag> results = new ArrayList<>();

        findMatchingBag(listOfBags,results,"shiny gold");
        int count = countChildrenBags(listOfBags,"shiny gold");
        System.out.println("Part 1: " + results.size());
        System.out.println("Part 2: " + count);

    }
    public static Bag parseInput(String line){

        Pattern pattern = Pattern.compile("(.*) bags contain (.*)$");
        Pattern embeddedPattern = Pattern.compile("([1-9]+) ([a-z ]+) bag");
        Matcher match = pattern.matcher(line);
        match.find();
        String bagColour = match.group(1);
        Bag result = new Bag(bagColour);

        String rhs = match.group(2);

        String containsList[] = rhs.split(",");
        if (rhs.equals("no other bags.")){
            return result;
        }
        for (String e: containsList){
            Matcher embeddedMatch = embeddedPattern.matcher(e);
            embeddedMatch.find();
            String count = embeddedMatch.group(1);
            String colour = embeddedMatch.group(2);
            result.containsBag(colour, Integer.parseInt(count));
        }
        return result;
    }
}
