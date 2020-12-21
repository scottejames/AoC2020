package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class DayTwentyOne {
//mxmxvkd kfcds sqjhc nhms (contains dairy, fish)
//trh fvjkl sbzzf mxmxvkd (contains dairy)
//sqjhc fvjkl (contains soy)
//sqjhc mxmxvkd sbzzf (contains fish)

    public static void main(String[] main) {
        FileHelper fh = new FileHelper("2020/DayTwentyOne.txt");
        List<String> data = fh.getFileAsList();

        Set<String> allergies = new HashSet<>();
        Set<String> ingredients = new HashSet<>();
        Map<String, Integer> counts = new HashMap<>();

        for (String line : data) {
            String[] parts = line.split(" \\(contains ");
            for (String ingredient : parts[0].split(" ")) {
                ingredients.add(ingredient);
                counts.merge(ingredient, 1, (o, n) -> o + n);
            }
            for (String aller : parts[1].replace(')', ' ').trim().split(", ")) {
                allergies.add(aller.trim());
            }
        }
        System.out.println(ingredients);
        System.out.println(counts);
        System.out.println(allergies);

        Map<String, Set<String>> possible = new HashMap<>();
        for (String aller : allergies) {
            possible.put(aller, new HashSet<>(ingredients));
        }
        System.out.println(possible);
        for (String line : data) {
            String[] parts = line.split(" \\(contains ");
            List<String> testIngredients = Arrays.asList(parts[0].split(" "));


            for (String testAllergies : parts[1].replace(')', ' ').trim().split(", ")) {
                for (String i : ingredients) {
                    if (!testIngredients.contains(i)) {
                        possible.get(testAllergies).remove(i);
                    }
                }
            }
        }
        System.out.println(possible);

        Set<String> complete = new HashSet<>();
        while (complete.size() < allergies.size()) {
            for (String aller : allergies) {
                if (possible.get(aller).size() == 1 && !complete.contains(aller)) {
                    complete.add(aller);
                    String v = getSetElement(possible.get(aller));
                    for (String b : allergies) {
                        if (!aller.equals(b)) {
                            possible.get(b).remove(v);
                        }
                    }
                }
            }
        }
        System.out.println("mapping: " + possible);
        Set<String> possibleIngredients = new HashSet<>();
        List<String> possibleIngedientsList = new ArrayList<>();
        for (var i: possible.values()){
            String item = getSetElement(i);
            possibleIngredients.add(item);
            possibleIngedientsList.add(item);
        }
        int partOne = 0;
        for (String ingredient: counts.keySet()){
            if (!possibleIngredients.contains(ingredient)){
                System.out.println("Adding : " + ingredient + " count " + counts.get(ingredient));
                partOne+=counts.get(ingredient);
            }
        }
        StringBuffer partTwo = new StringBuffer();

        for (String allergy : allergies.stream().sorted().collect(Collectors.toList())){
            partTwo.append(getSetElement(possible.get(allergy)) + ",");

        }
        System.out.println("Part 1: " +possibleIngedientsList);
        System.out.println("Part 2: " +partTwo.toString());

    }
    private static String getSetElement(Set<String> set) {
        String result = set.iterator().next();
        return result;
    }

}
