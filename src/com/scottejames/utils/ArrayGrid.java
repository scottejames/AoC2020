package com.scottejames.utils;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class ArrayGrid {
    private  int height = 0;
    private  int width = 0;





    private  char[][] gridData = null;

    public ArrayGrid(char[][] gridData){
        height= gridData.length;
        width = gridData[0].length;
        this.gridData = Arrays.stream(gridData).map(char[]::clone).toArray(char[][]::new);
    }

    public ArrayGrid(ArrayGrid gridData){
        height=gridData.getHeight();
        width = gridData.getWidth();
        this.gridData = Arrays.stream(gridData.getGridData()).map(char[]::clone).toArray(char[][]::new);
    }

    public  void showGrid(){
        for (int y = 0;y < height;y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(gridData[y][x]);
            }
            System.out.println("");
        }
        System.out.println("");

    }
    public char getInGrid( Point p, char none){
        if(p.y>=0 && p.y<gridData.length && p.x>=0 && p.x<gridData[0].length){
            return gridData[p.y][p.x];
        }
        return none;
    }

    public char getInGrid( Point p){
        return getInGrid( p, '.');
    }

    public void setInGrid(Point p, char c) {
        if(p.y>=0 && p.y<gridData.length && p.x>=0 && p.x<gridData[0].length){
            gridData[p.y][p.x] = c;
        }
    }
    public int countPath(Point p, Direction d,char c){
        int count = 0;
        while (c==getInGrid(p)) {
            count++;
            p = d.move(p);
        }
        return count;
    }

    // Day 11
    public int canSeeNeighbours(Point p){
        char outOfBounds = '-';
        char neighbour = '#';
        char empty= 'L';

        Point origin = new Point(p);
        int count = 0;
        for (Direction d: Direction.eightDirections()) {
            boolean go = true;
            Point newSpace = origin;
            while (go) {
                newSpace = d.move(newSpace);
                char test = getInGrid(newSpace, '-');
                if (test == '#') {
                    count++;
                    go = false;
                }
                if ((test == '-') || (test == 'L')) {
                    go = false;
                }
            }
        }
        return count;
    }
    public int checkNeighbours(Point p, char c){
        Point origin = new Point(p);
        int count = 0;
        for (Direction d: Direction.eightDirections()){
            Point testPoint = d.move(origin);
            if (getInGrid(testPoint)==c){
                count++;
            }
        }
        return count;
    }

    public int getCharCount(char c){
        int count = 0;
        for (int i = 0; i < height ; i++)
            for (int j=0; j < width; j++) {
                if (gridData[i][j] == c)
                    count++;
            }
        return count;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth(){
        return width;
    }
    public char[][] getGridData() {
        return gridData;
    }

    public boolean equals(ArrayGrid o) {
        if (o==null){
            return false;
        }
        boolean same = true;
        for (int i = 0; i < width; i++)
            for (int j=0; j < height; j++) {
                if (o.getInGrid(new Point(j,i)) != getInGrid(new Point(j,i))){
                    same = false;
                }
            }
        return same;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(height, width);
        result = 31 * result + Arrays.hashCode(gridData);
        return result;
    }
}
