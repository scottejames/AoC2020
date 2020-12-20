package com.scottejames.aoc2020;

import com.scottejames.utils.ArrayHelper;
import com.scottejames.utils.StringHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

//Tile 2311:
//..##.#..#.
//##..#.....
//#...##..#.
//####.#...#
//##.##.###.
//##...#.###
//.#.#.#..##
//..#....#..
//###...#.#.
//..###..###
public class Tile20 {
    public int ID;
    public List<Integer> edge;
    public boolean[][] data;
    public int height;
    public int width;


    public Tile20(List<String> sourceData){
        ID = Integer.parseInt(sourceData.get(0).split(" ")[1].replace(":", ""));

        height = sourceData.size() - 1;
        width = sourceData.get(1).length();

        data = new boolean[width][height];

        for (int y = 0; y < height; y++) {
            String line = sourceData.get(y+1);
            for (int x = 0; x < width; x++) {
                data[y][x] = (line.charAt(x) == '#');
            }
        }
        boolean[] e = new boolean[width];
        edge = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            e[i] = data[i][0];
        }
        addEdge(e);
        for (int i = 0; i < width; i++) {
            e[i] = data[i][height - 1];
        }
        addEdge(e);
        for (int i = 0; i < width; i++) {
            e[i] = data[0][i];
        }
        addEdge(e);
        for (int i = 0; i < width; i++) {
            e[i] = data[width - 1][i];
        }
        addEdge(e);
        System.out.println(this);
    }
    private void addEdge(boolean [] e){
        this.edge.add(getBinary(e));

        boolean reverse[] = new boolean[e.length];
        int i = e.length-1;
        for (boolean item:e){
            reverse[i--]= item;
        }
        this.edge.add(getBinary(reverse));
    }

    private static Integer getBinary(boolean[] d) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < d.length; i++) {
            if (d[i]) {
                str.append("1");
            } else {
                str.append("0");
            }
        }
        return Integer.valueOf(str.toString(), 2);
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();

        sb.append("Tile: " + ID + "\n");

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                sb.append(data[y][x] ? '#' : '.');
            }
            sb.append("\n");
        }
        sb.append("\n");
        for (Integer i: edge){
            sb.append(StringHelper.toBinary(i,10) + "\n");
        }

        return sb.toString();
    }

}
