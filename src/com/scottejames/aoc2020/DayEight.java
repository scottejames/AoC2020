package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;

import java.util.ArrayList;
import java.util.List;

public class DayEight {


    public static void main(String [] args){
        FileHelper fh = new FileHelper("2020/DayEight.txt");
        List<String> data = fh.getFileAsList();

//        Assem assem = new Assem(Assem.compile(data));
//        assem.run();
//        System.out.println("Part 1: " + assem.getAccumlator());

        boolean foundSolution = false;
        int count = 0;
        while (foundSolution == false){
            List<String> newProgram = mutateProgram(data,count);
            Assem assem = new Assem(Assem.compile(newProgram));
            if (assem.run() != -1){
                System.out.println("Found solution accum " + assem.getAccumlator());
                foundSolution = true;
            }
            count++;

        }
    }

    public static List<String> mutateProgram(List<String> data,int count){
        List<String> result = new ArrayList<>(data);
        int index = 0;

        for (int i = 0;i < result.size();i++){
            Instruction instruction = new Instruction(data.get(i));

            if (instruction.getInstuction().equals(Instruction.JMP)){
                if (index==count){
                    result.set(i,Instruction.NOP + " " + instruction.getArgument());
                }
                index++;
            }
            if (instruction.getInstuction().equals(Instruction.NOP)){
                if (index==count){
                    result.set(i,Instruction.JMP + " " +instruction.getArgument());
                }
                index++;
            }
        }
        return result;
    }
}

