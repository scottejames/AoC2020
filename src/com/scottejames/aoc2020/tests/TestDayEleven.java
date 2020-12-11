package com.scottejames.aoc2020.tests;

import com.scottejames.aoc2020.DayEleven;
import com.scottejames.utils.ArrayGrid;
import com.scottejames.utils.Direction;
import com.scottejames.utils.FileHelper;
import com.scottejames.utils.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDayEleven {

    @Test
    public void testCountingChairs(){
        FileHelper fh = new FileHelper("2020/DayElevenCountTest.txt");
        char [][] gridData= fh.getFileAsCharArray();

//        int countChairs = DayEleven.countChairs(gridData,new Point(0,0), Direction.EAST);
//        assertTrue(countChairs==4);
//        countChairs = DayEleven.countChairs(gridData,new Point(0,0), Direction.SOUTH);
//        assertTrue(countChairs==4);
//        countChairs = DayEleven.countChairs(gridData,new Point(0,2), Direction.SOUTH);
//        assertTrue(countChairs==2);
//        countChairs = DayEleven.countChairs(gridData,new Point(0,3), Direction.WEST);
//        assertTrue(countChairs==1);
//        countChairs = DayEleven.countChairs(gridData,new Point(0,4), Direction.WEST);
//        assertTrue(countChairs==0);
    }



    @Test
    public void testBug(){

        FileHelper fh = new FileHelper("2020/DayElevenCountTest.txt");
        char [][] gridData= fh.getFileAsCharArray();

        Point p = new Point(3,0);

        ArrayGrid ag = new ArrayGrid(gridData);
        boolean endOfRow = false;
        for (Direction d: Direction.fourDirections()){
            int count = ag.countPath(p,d,'#');
            if (count == 4){
                endOfRow = true;
            }
        }
        assertTrue(endOfRow);

    }
}
