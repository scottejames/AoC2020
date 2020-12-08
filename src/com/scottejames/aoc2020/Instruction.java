package com.scottejames.aoc2020;

public class Instruction {
    public static final String ACC = "acc";
    public static final String NOP = "nop";
    public static final String JMP = "jmp";

    private String instuction;
    private int argument;

    public Instruction(String input){
        String [] array = input.split(" ");
        instuction = array[0];
        argument = Integer.parseInt(array[1]);

    }

    public String toString(){
        return instuction + " " + argument;
    }
    public String getInstuction() {
        return instuction;
    }

    public void setInstuction(String instuction) {
        this.instuction = instuction;
    }

    public int getArgument() {
        return argument;
    }

    public void setArgument(int argument) {
        this.argument = argument;
    }
}
