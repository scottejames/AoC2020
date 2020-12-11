package com.scottejames.aoc2020.tests;

import com.scottejames.utils.ArrayGrid;
import com.scottejames.utils.FileHelper;
import com.scottejames.utils.Point;
import org.junit.Before;
import org.junit.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestArray {
    char[][] testData = null;
    @Before
    public void setupData() {
        testData = new char[][]{
                {'#', '#', '#', '.'},
                {'#', '.', '.', '.'},
                {'#', '#', '.', '.'},
                {'#', '.', '.', '.'}};
    }

    @Test
    public void testCreateGrid() {
        ArrayGrid ag = new ArrayGrid(testData);
        assertTrue(ag.getWidth() == 4);
        assertTrue(ag.getHeight() == 4);
    }

    @Test
    public void testGridDataGet() {
        ArrayGrid ag = new ArrayGrid(testData);
        Point p = new Point(0, 0);
        assertTrue(ag.getInGrid(p) == '#');
        p = new Point(0, 5);
        assertTrue(ag.getInGrid(p) == '.');
        assertTrue(ag.getInGrid(new Point(-1, 0)) == '.');
        assertTrue(ag.getInGrid(new Point(5, 0)) == '.');
        assertTrue(ag.getInGrid(new Point(-10, 100)) == '.');
        assertTrue(ag.getInGrid(new Point(-1, 1)) == '.');

    }

    @Test
    public void testFindNeighbours(){
        ArrayGrid ag = new ArrayGrid(testData);
        int count = ag.checkNeighbours(new Point(0,0),'#');
        assertTrue(count == 2);
        count = ag.checkNeighbours(new Point(1,1),'#');
        assertTrue(count == 6);
        count = ag.checkNeighbours(new Point(3,3),'#');
        assertTrue(count == 0);
    }
    @Test
    public void testEquality(){
        ArrayGrid ag = new ArrayGrid(testData);
        ArrayGrid agTwo = new ArrayGrid(ag);

        assertTrue(ag.equals(agTwo));
        ag.setInGrid(new Point(0,1),'P');
        assertFalse(ag.equals(agTwo));

    }

    @Test
    public void testVisableNeighbours() {
        testData = new char[][]{
                new String(".............").toCharArray(),
                new String(".L.L.#.#.#.#.").toCharArray(),
                new String(".............").toCharArray()
        };
        ArrayGrid ag = new ArrayGrid(testData);

        int count = ag.canSeeNeighbours(new Point(3, 1));
        assertTrue(count==1);
        count = ag.canSeeNeighbours(new Point(1, 1));
        assertTrue(count==0);
    }
    @Test
    public void testVisableNeighbourTwo() {
        testData = new char[][]{
                new String(".......#.").toCharArray(),
                new String("...#.....").toCharArray(),
                new String(".#.......").toCharArray(),
                new String(".........").toCharArray(),
                new String("..#L....#").toCharArray(),
                new String("....#....").toCharArray(),
                new String(".........").toCharArray(),
                new String("#........").toCharArray(),
                new String("...#.....").toCharArray()
        };
        ArrayGrid ag = new ArrayGrid(testData);

        int count = ag.canSeeNeighbours(new Point(3, 4));
        assertTrue(count==8);

    }
}
