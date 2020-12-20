package com.scottejames.aoc2020.tests;

import com.scottejames.aoc2020.DayNinteen;
import com.scottejames.utils.FileHelper;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class DayNinteenTest {

    public void loadRules(){
        FileHelper fh = new FileHelper("2020/DayNinteenTest.txt");
        List<String> data =fh.getFileAsList();

        var rules = DayNinteen.loadRules(data);
        assertTrue(rules.size() == 4);


    }
    //0: 1 2
    //1: "a"
    //2: 1 3 | 3
    @Test
    public void getSimpleRule(){
        FileHelper fh = new FileHelper("2020/DayNinteenTest.txt");
        List<String> data =fh.getFileAsList();

        var rules = DayNinteen.loadRules(data);
        var result = DayNinteen.matchRule(0,rules);
        assertTrue(result.size() == 2);
    }

    //0: 4 1 5
    //1: 2 3 | 3 2
    //2: 4 4 | 5 5
    //3: 4 5 | 5 4
    //4: "a"
    //5: "b"
    @Test
    public void getInterestingRule() {
        FileHelper fh = new FileHelper("2020/DayNinteenTestTwo.txt");
        List<String> data = fh.getFileAsList();

        var rules = DayNinteen.loadRules(data);
        var result = DayNinteen.matchRule(0, rules);
        System.out.println(result);
    }

}
