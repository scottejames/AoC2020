package com.scottejames.aoc2020.tests;

import com.scottejames.aoc2020.DayFive;
import com.scottejames.utils.Range;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDayFive {

    @Test
    public void testRowPartition(){
        Range r = new Range(0,7);
        r = DayFive.partition(r, DayFive.PartitionDirection.UP);

        assertEquals(r.min, 4);
        assertEquals(r.max,7);
        r = DayFive.partition(r, DayFive.PartitionDirection.DOWN);

        assertEquals(r.min, 4);
        assertEquals(r.max,5);
        r = DayFive.partition(r, DayFive.PartitionDirection.UP);

        assertEquals(r.min, 5);
        assertEquals(r.max,5);

    }
    @Test
    public void testColumnPartitionFromString(){
        int row = DayFive.getColumn("RLR");
        assertEquals(row,5);
    }
    @Test
    public void testRowPartitionFromString(){
        int row = DayFive.getRow("FBFBBFF");
        assertEquals(row,44);
    }

    @Test
    public void testPartition(){

        Range r = new Range(0,127);
        r = DayFive.partition(r, DayFive.PartitionDirection.DOWN);

        assertEquals(r.min,0);
        assertEquals(r.max, 63);
        r = DayFive.partition(r, DayFive.PartitionDirection.UP);

        assertEquals(r.min,32);
        assertEquals(r.max, 63);
        r = DayFive.partition(r, DayFive.PartitionDirection.DOWN);

        assertEquals(r.min,32);
        assertEquals(r.max, 47);
        r = DayFive.partition(r, DayFive.PartitionDirection.UP);

        assertEquals(r.min,40);
        assertEquals(r.max, 47);
        r = DayFive.partition(r, DayFive.PartitionDirection.UP);

        assertEquals(r.min,44);
        assertEquals(r.max, 47);
        r = DayFive.partition(r, DayFive.PartitionDirection.DOWN);

        assertEquals(r.min,44);
        assertEquals(r.max, 45);
        r = DayFive.partition(r, DayFive.PartitionDirection.DOWN);

        assertEquals(r.min,44);
        assertEquals(r.max, 44);
    }

    @Test
    public void testSeatNumber(){
        int seatNumber = DayFive.getSeatNumber("FBFBBFFRLR");
        assertEquals(357,seatNumber);
    }
    @Test
    public void testSeatNumberTwo(){
        int seatNumber = DayFive.getSeatNumber("BFFFBBFRRR");
        assertEquals(567,seatNumber);
    }    @Test
    public void testSeatNumberThree(){
        int seatNumber = DayFive.getSeatNumber("FFFBBBFRRR");
        assertEquals(119,seatNumber);
    }
    public void testSeatNumberFour(){
        int seatNumber = DayFive.getSeatNumber("BBFFBBFRLL");
        assertEquals(820,seatNumber);
    }
    @Test
    public void testStringSplit(){
        String key = "FBFBBFFRLR";
        String row = key.substring(0,7);
        String column = key.substring(7,10);
        assertTrue(row.equals("FBFBBFF"));
        assertTrue(column.equals("RLR"));
    }
}
