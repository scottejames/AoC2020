package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;

import java.util.List;

public class DayThree {

    public static void main(String [] args){
        FileHelper fh = new FileHelper("2020/DayThree.txt");
        List<String> data = fh.getFileAsList();
        //Right 1, down 1.
        //Right 3, down 1. (This is the slope you already checked.)
        //Right 5, down 1.
        //Right 7, down 1.
        //Right 1, down 2.

        //int treeCount = ;
        System.out.println("trees " + countTrees(data, 1,1)
                * countTrees(data, 3,1)
                * countTrees(data, 5,1)
                * countTrees(data, 7,1)
                * countTrees(data, 1,2));

    }

    private static int countTrees(List<String> data, int xDelta, int yDelta) {
        int x = 0;
        int y = 0;
        int treecount=0;

        int dataWidth = data.get(0).length();

        while (y< data.size()) {

            if (data.get(y).charAt(x) == '#') {
                treecount++;
            }
            x += xDelta;
            x %= dataWidth;
            y += yDelta;
        }
        return treecount;
    }
}
