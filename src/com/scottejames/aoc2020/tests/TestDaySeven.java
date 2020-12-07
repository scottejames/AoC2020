package com.scottejames.aoc2020.tests;

import com.scottejames.aoc2020.DaySeven;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestDaySeven {

    @Test
    public void testParseBasicString(){
        String line = "light red bags contain 1 bright white bag, 2 muted yellow bags.";
        DaySeven.parseInput(line);
    }
    @Test
    public void testParseTerminalString(){
        String line = "faded blue bags contain no other bags.";
        DaySeven.parseInput(line);
    }

    @Test
    public void testCreateBag(){
        String line = "light red bags contain 1 bright white bag, 2 muted yellow bags.";
        DaySeven.Bag bag = DaySeven.parseInput(line);
        assertNotNull(bag);
        assertTrue(bag.colour.equals("light red"));
        assertTrue(bag.containedBags.size() == 2);
    }
}
