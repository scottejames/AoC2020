package com.scottejames.aoc2020.tests;

import com.scottejames.aoc2020.DayNine;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class TestDayNine {

    @Test
    public void testOneToTwentyFive(){
        List<Long> list = LongStream.rangeClosed(1,25).boxed().collect(toList());

        assertEquals(DayNine.checkIfPossibleSumInArray(list,26),true);
        assertEquals(DayNine.checkIfPossibleSumInArray(list,49),true);
        assertEquals(DayNine.checkIfPossibleSumInArray(list,100),false);
        assertEquals(DayNine.checkIfPossibleSumInArray(list,50),false);
    }
}
