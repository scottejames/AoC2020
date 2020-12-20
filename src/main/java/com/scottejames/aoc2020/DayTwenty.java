package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayTwenty {


    public static void main(String [] args){

        FileHelper fh = new FileHelper("2020/DayTwenty.txt");
        List<String> data = fh.getFileAsList();
        List<String> tileData = new ArrayList<>();
        List<Tile20> tiles = new ArrayList<>();

        for (String line:data){
            if (line.isEmpty()){
                tiles.add(new Tile20(tileData));
                tileData = new ArrayList<>();
                continue;
            }
            tileData.add(line);
        }
        Map<Integer, Integer> match = new HashMap<>();

        for (Tile20 t : tiles) {
            for (Integer i : t.edge) {
                int count = match.getOrDefault(i,0);
                match.put(i,count +1);
            }
        }

        System.out.println(match);

        long part1 = 1;
        for (Tile20 t : tiles) {
            int count = 0;

            for (Integer i : t.edge) {
                if (match.get(i).equals(1)) {
                    count++;
                }
            }
            if (count == 4)
                part1*=t.ID;
            System.out.println("T " + t.ID + " - count : " + count);
        }
        System.out.println("part 1 : " + part1);
    }
}
