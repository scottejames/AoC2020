package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;
import com.scottejames.utils.HexDirection;
import com.scottejames.utils.Point;
import com.scottejames.utils.Tripple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DayTwentyFour {
    private static int maxX = Integer.MIN_VALUE;
    private static int maxY = Integer.MIN_VALUE;
    private static int minX = Integer.MAX_VALUE;
    private static int minY = Integer.MAX_VALUE;

    private static Set<Point> visited = new HashSet<>();

    public static void main(String [] args){

        FileHelper fh = new FileHelper("2020/DayTwentyFour.txt");
        List<String> data = fh.getFileAsList();

        partOne(data);
        partTwo();
    }
    private static void partTwo(){
        for (int i = 0; i < 100;i++) {
            Set<Point> newVisited = new HashSet<>();
            calcMinMax();
            int gridGrow = 2;
            for (int y=minY-gridGrow;y<maxY +gridGrow;y++){
                for (int x=minX-gridGrow;x<maxX +gridGrow;x++) {
                    Point currentSquare = new Point(x,y);

                    int count = countNeighbours(currentSquare);
                    boolean active = visited.contains(currentSquare);

                    if((active && (count == 1 || count == 2)) ||
                            (!active && count == 2)){
                        newVisited.add(currentSquare);
                    }
                }
            }
            visited = newVisited;
            System.out.println("Part Two " + visited.size());
        }

    }

    private static void partOne(List<String> data) {
        for (String line : data){
            List<HexDirection> directions = readLine(line);
            Point pos = new Point(0,0);
            for(HexDirection dir : directions){
                pos = dir.move(pos);
            }
            if(!visited.add(pos)){
                visited.remove(pos);
            }
        }
        System.out.println("Part 1: " + visited.size());
    }
    public static void calcMinMax(){
        for (Point p: visited){
            if (p.x < minX){
                minX = p.x;
            }
            if (p.y < minY){
                minY = p.y;
            }
            if (p.x > maxX){
                maxX = p.x;
            }
            if (p.y > maxY){
                maxY = p.y;
            }

        }
    }
    public static int countNeighbours(Point p) {
        int count = 0;
        for (HexDirection dir : HexDirection.values()) {
            if (visited.contains(dir.move(p))){
                count++;
            }
        }
        return count;
    }
    public static List<HexDirection> readLine(String line){
        int index = 0;
        List<HexDirection> result = new ArrayList<HexDirection>();
        while (index < line.length()){
            HexDirection direction;
            char c = line.charAt(index);
            if ((c == 's') || (c =='n')){
                direction = HexDirection.get(line.substring(index,index+2));
                index+=2;
            } else {
                direction = HexDirection.get(c + "");
                index++;
            }
            result.add(direction);
        }
        return result;
    }
    public static void showGrid() {
        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                final boolean status = visited.contains(new Point(x, y));
                char c = status ? '#' : '.';
                System.out.print(c);
            }
            System.out.println("");
        }
        System.out.println("");

    }
}
