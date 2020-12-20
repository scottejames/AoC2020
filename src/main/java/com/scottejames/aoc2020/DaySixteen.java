package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;
import com.scottejames.utils.Pair;
import com.scottejames.utils.StringHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class DaySixteen {

    public static void main(String [] args){

        FileHelper fh = new FileHelper("2020/DaySixteenTestTwo.txt");
        List<String> data = fh.getFileAsList();
        List<Long> nearTicketList = new ArrayList<>();
        List<Long> ticketList = new ArrayList<>();
        List<Rule> ruleList = new ArrayList<>();

        HashMap<Rule,List<Long>> validElementsByRule = new HashMap<>();
        int section = 0;

        for (String line: data){
            if (line.isEmpty()) {
                section++;
                continue;
            }
            if (line.startsWith("your ticket"))
                continue;
            if (line.startsWith("nearby ticket"))
                continue;

            if (section == 0){
                String arr[] = line.split(":");
                String name = arr[0];
                Pair firstPair = StringHelper.splitRangeToPair(arr[1].split("or")[0]);
                Pair secondPair = StringHelper.splitRangeToPair(arr[1].split("or")[1]);
                Rule rule = new Rule(name, firstPair,secondPair);
                ruleList.add(rule);
            } else if (section == 1) {
                for (long ticket:stream(line.split(",")).mapToInt(Integer::parseInt).toArray())
                    ticketList.add(ticket);
            } else if (section == 2){
                for (long ticket: stream(line.split(",")).mapToInt(Integer::parseInt).toArray())
                    nearTicketList.add(ticket);
            } else{
                throw new RuntimeException("Found line i cant process " + line);
            }
        }
        List<Long> inValidTickets = nearTicketList.stream().
                filter(ticket -> findInvalid(ruleList,ticket) == false).collect(Collectors.toList());
        long result = inValidTickets.stream().collect(Collectors.summingLong(Long::longValue));

        System.out.println("inValid tickets " + inValidTickets);
        System.out.println("Part one result " + result);

        List<Long> validTickets = nearTicketList.stream().
                filter(ticket -> findValid(ruleList,ticket) == false).collect(Collectors.toList());
        System.out.println("valid tickets " + validTickets);

        for (Rule rule: ruleList){
            List<Long> validList = validTickets.stream().
                    filter(ticket -> rule.check(ticket)).collect(Collectors.toList());
            validElementsByRule.put(rule,validList);
        }
        System.out.println(validElementsByRule);
    }

    public static boolean findInvalid(List<Rule> ruleList, long value){
        long size= ruleList.stream().filter(r -> r.check(value) ==true).count();
        return size!=0;
    }
    public static boolean findValid(List<Rule> ruleList, long value){
        long size = ruleList.stream().filter(r -> r.check(value) ==false).count();
        return size==0;
    }
    public static class Rule{
        String id;
        int firstLower;
        int firstUpper;
        int secondLower;
        int secondUpper;

        public Rule(String id, Pair<Integer,Integer> first, Pair<Integer,Integer> second){
            this.id = id;
            firstLower = first.getLhs();
            firstUpper = first.getRhs();
            secondLower = second.getLhs();
            secondUpper = second.getRhs();

        }

        @Override
        public String toString() {
            return "Rule{" +
                    "id='" + id + '\'' +
                    ", firstLower=" + firstLower +
                    ", firstUpper=" + firstUpper +
                    ", secondLower=" + secondLower +
                    ", secondUpper=" + secondUpper +
                    '}';
        }

        public boolean check(long val) {
            return (val >= firstLower && val <= firstUpper) || (val >= secondLower && val <= secondUpper);
        }
    }
}
