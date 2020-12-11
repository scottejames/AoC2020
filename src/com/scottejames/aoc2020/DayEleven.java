package com.scottejames.aoc2020;

import com.scottejames.utils.*;

import static java.util.Arrays.stream;

public class DayEleven {
    private static ArrayGrid grid = null;

    public static void main(String [] args){

        FileHelper fh = new FileHelper("2020/DayEleven.txt");
        grid = new ArrayGrid(fh.getFileAsCharArray());
        ArrayGrid newGrid = null;
        while (true) {
            newGrid = nextStagePartTwo();
            if (grid.equals(newGrid)) {
                break;
            }
//            grid.showGrid();

            grid=newGrid;

        }
        grid.showGrid();
        System.out.println("Part 2 " + grid.getCharCount('#'));

    }
    public static ArrayGrid nextStagePartOne(){
        ArrayGrid newGrid = new ArrayGrid(grid);
        for(int j = 0; j< grid.getHeight(); j++) {
            for(int i = 0; i< grid.getWidth(); i++){
                Point p = new Point(i, j);
                boolean endOfRow = false;

                int neighbourCount = grid.checkNeighbours(p,'#');

                char current = grid.getInGrid(p);

                if (current != '.'){
                    if ((current == 'L') && (neighbourCount==0)){
                        newGrid.setInGrid(p,'#');
                    } else if ((current == '#') && (neighbourCount >= 4)){
                        newGrid.setInGrid(p,'L');
                    }
                }
            }
        }
        return newGrid;

    }

    public static ArrayGrid nextStagePartTwo(){
        ArrayGrid newGrid = new ArrayGrid(grid);
        for(int j = 0; j< grid.getHeight(); j++) {
            for(int i = 0; i< grid.getWidth(); i++){
                Point p = new Point(i, j);
                boolean endOfRow = false;

                int neighbourCount = grid.canSeeNeighbours(p);

                char current = grid.getInGrid(p);

                if (current != '.'){
                    if ((current == 'L') && (neighbourCount==0)){
                        newGrid.setInGrid(p,'#');
                    } else if ((current == '#') && (neighbourCount >= 5)){
                        newGrid.setInGrid(p,'L');
                    }
                }
            }
        }
        return newGrid;

    }
    public static int countChairs(Point p,Direction d){
        return grid.countPath(p,d,'#');
    }


}
