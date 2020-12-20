package com.scottejames.aoc2020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Assem {
    private int accumlator = 0;
    private int programCounter = 0;
    private boolean running = true;
    private List<Instruction> program = null;

    public Assem(List<Instruction> program) {
        this.program = program;
    }

    public static List<Instruction> compile(List<String> input) {
        List<Instruction> program = new ArrayList<Instruction>();

        for (String s : input) {
            program.add(new Instruction(s));
        }
        return program;
    }


    public int run() {
        Set executed = new HashSet<Integer>();
        while(running){
            if (programCounter>=program.size()){
                System.out.println("TERMINATED");
                return 1;
            }
            Instruction instr = program.get(programCounter);
            System.out.println(programCounter + " : " + instr);

            switch (instr.getInstuction()){
                case Instruction.ACC:
                    accumlator += instr.getArgument();
                    programCounter++;
                    break;
                case Instruction.JMP:
                    programCounter += instr.getArgument();
                    break;
                case Instruction.NOP:
                    programCounter++;
                    break;
                default:
                    programCounter++;
                    break;
            }

            if (executed.contains(programCounter)){
                running = false;
            }else{
                executed.add(programCounter);
            }
        }
        System.out.println("LOOPS, BREAKING");

        return -1;

    }
    public int getAccumlator(){
        return accumlator;
    }


}
