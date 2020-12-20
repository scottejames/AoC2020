package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;
import com.scottejames.utils.SparceGrid;
import com.scottejames.utils.Tripple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DaySeventeen {

    public static void main(String [] args) {

        FileHelper fh = new FileHelper("2020/DaySeventeen.txt");
        List<String> data = fh.getFileAsList();
        final List<Tripple> gridData = new ArrayList<>();
        int y =0;
        for (String line: data){

            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '#') {
                    gridData.add(new Tripple(x, y, 0, 0));
                }
            }
            y++;
        }

        SparceGrid grid = new SparceGrid(gridData);
        for (int i=0;i<6;i++)
            grid.tick();
        System.out.println("Part 1: " + grid.countActive());
        grid = new SparceGrid(gridData);
        for (int i=0;i<6;i++)
            grid.tick4d();
        System.out.println("Part 2: " + grid.countActive());


    }
}
