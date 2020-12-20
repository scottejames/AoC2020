package com.scottejames.aoc2020.tests;

import com.scottejames.utils.Pair;
import com.scottejames.utils.StringHelper;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestStringHelper {

    @Test
    public void testParseRange(){

        String test = "1-2";
        String testTwo = "10-1";
        String testThree = " 100-99909 ";

        Pair<Integer,Integer> result = null;
        result = StringHelper.splitRangeToPair(test);
        assertTrue(result.getLhs()==1);
        assertTrue(result.getRhs()==2);

        result = StringHelper.splitRangeToPair(testTwo);
        assertTrue(result.getLhs()==10);
        assertTrue(result.getRhs()==1);


        result = StringHelper.splitRangeToPair(testThree);
        assertTrue(result.getLhs()==100);
        assertTrue(result.getRhs()==99909);

    }
}
