package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;

import java.util.ArrayList;
import java.util.List;

public class DayThirteen {
    public static void main(String[] args) {

        FileHelper fh = new FileHelper("2020/DayThirteenTest.txt");
        List<String> data = fh.getFileAsList();

        Long earliest = Long.parseLong(data.get(0));
        String[] bussData = data.get(1).split(",");
        List<Bus> busses = new ArrayList<>();
        for (int i =  0; i < bussData.length;i++) {

            try {
                busses.add(new Bus(Long.parseLong(bussData[i]),i));
            } catch (NumberFormatException ignored) {// ignore X}
            }
        }

        partOne(earliest, busses);
        partTwo(earliest, busses);
    }
    private static void partTwo(Long earliest, List<Bus> busses){
        for (Bus bus: busses){
            System.out.println("(x + " + bus.offset+ ") mod " + bus.id + " == 0,");

            //System.out.println(bus.id);
//            System.out.println((-1 * bus.offset) % bus.id);
        }
    }
    private static void partOne(Long earliest, List<Bus> busses) {
        long busFound = 0;
        Long time = earliest;
        while (busFound == 0) {
            for (Bus bus : busses) {
                if (bus.schedule(time) == true) {
                    busFound = bus.id;
                }
            }
            time++;
        }
        System.out.println((time - earliest - 1) * busFound);
    }

    private static class Bus{
        public long id;
        public long offset;
        public Bus(){
        }

        public Bus(long id, long offset) {
            this.id = id;
            this.offset = offset;
        }
        public boolean schedule(long timeStamp) {
            return (timeStamp % id) == 0;
        }
    }
}

