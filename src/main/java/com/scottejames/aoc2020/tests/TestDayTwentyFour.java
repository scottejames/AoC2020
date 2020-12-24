package com.scottejames.aoc2020.tests;

import com.scottejames.aoc2020.DayTwentyFour;
import com.scottejames.utils.HexDirection;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestDayTwentyFour {

    @Test
    public void testLoadDirectionString(){
        List<HexDirection> results = DayTwentyFour.readLine("nwwswee");
        assertTrue(results.size() == 5);
        assertTrue(results.get(0) == HexDirection.NORTHWEST);

    }
}
