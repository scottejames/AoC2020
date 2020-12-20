package com.scottejames.aoc2020.tests;

import com.scottejames.aoc2020.DayTwo;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestDayTwo {
    @Test
    public void testValidExample(){
        String data = "17-18 z: zzzzzzzzdzzzzzzgzr";
        boolean result = DayTwo.validate(data);
        assertTrue(result == false);

    }
}
