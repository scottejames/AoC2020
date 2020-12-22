package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;

import java.util.*;

public class DayTwentyTwo {

    public static void main(String[] args) {
        Queue<Integer> p1 = new LinkedList<>();
        Queue<Integer> p2 = new LinkedList<>();

        FileHelper fh = new FileHelper("2020/DayTwentyTwo.txt");
        List<String> data = fh.getFileAsList();
        boolean playerOne = true;
        for (String line : data) {
            if (line.isEmpty()) {
                playerOne = false;
                continue;
            }
            if (!line.contains("Player")) {
                if (playerOne) {
                    p1.add(Integer.parseInt(line));
                } else {
                    p2.add(Integer.parseInt(line));
                }
            }
        }
        System.out.println(p1);
        System.out.println(p2);
//        int round = 0;
//        while (!p1.isEmpty() && !p2.isEmpty()) {
////        while (round < 10){
//            round++;
//
//            Integer p1Card = p1.remove();
//            Integer p2Card = p2.remove();
//            System.out.println("Player 1: " + p1Card + " Player 2: " + p2Card);
//            if (p1Card > p2Card) {
//                System.out.println("Player 1 wins");
//                p1.add(p1Card);
//                p1.add(p2Card);
//            } else {
//                System.out.println("Player 2 wins");
//                p2.add(p2Card);
//                p2.add(p1Card);
//            }
//        }
//        System.out.println("finished on round " + round);
//        System.out.println(p1);
//        System.out.println(p2);
//
//        Queue<Integer> winner = p2.isEmpty() ? p1 : p2;
//
//        int score = scoreHand(winner);
//
//        System.out.println("Part 1: " + score);
        int score;
        boolean p1IsWinner = playPartTwo(p1,p2);
        if (p1IsWinner)
            score = scoreHand(p1);
        else
            score = scoreHand(p2);
        System.out.println("Part 2: " + score);

    }

    private static int scoreHand(Queue<Integer> winner) {
        long cardValue = winner.size();
        int score = 0;
        for (int card : winner) {
            score += card * cardValue;
            cardValue--;
        }
        return score;
    }
    // return true if p1 won
    public static boolean playPartTwo(Queue<Integer> p1, Queue<Integer> p2) {
        Set<List<Queue<Integer>>> uniqueHands = new HashSet<>();
        int round = 0;

        while (!p1.isEmpty() && !p2.isEmpty()) {
            if (notUnique(uniqueHands, p1, p2)) // bad loop
                return true;
            round++;
            Integer p1Card = p1.remove();
            Integer p2Card = p2.remove();
            boolean p1Wins = true;
//            System.out.println("Player 1: " + p1Card + " Player 2: " + p2Card);

            if (p1.size() < p1Card || p2.size() < p2Card) {
                p1Wins = p1Card > p2Card;
            } else { // recursive combat?

                Queue<Integer> p1NewDeck = new LinkedList<>();
                Queue<Integer> p2NewDeck = new LinkedList<>();

                int newDeckSize = p1Card;
                for (int card : p1) {
                    if (newDeckSize <= 0) break;
                    p1NewDeck.add(card);
                    newDeckSize--;
                }
                newDeckSize = p2Card;
                for (int card :p2) {
                    if (newDeckSize <= 0) break;
                    p2NewDeck.add(card);
                    newDeckSize--;
                }
                p1Wins = playPartTwo(p1NewDeck, p2NewDeck);
            }
            if (p1Wins) {
//                System.out.println("Player 1 wins");
                p1.add(p1Card);
                p1.add(p2Card);
            } else {
//                System.out.println("Player 2 wins");
                p2.add(p2Card);
                p2.add(p1Card);
            }
        }
        System.out.println("finished on round " + round);
        System.out.println(p1);
        System.out.println(p2);
        boolean result = p2.isEmpty() ? true : false;
        return result;

    }
    public static boolean notUnique(Set<List<Queue<Integer>>> seen,
                                     Queue<Integer> p1, Queue<Integer> p2) {
        List<Queue<Integer>> l = new ArrayList<>();
        l.add(p1);
        l.add(p2);
        boolean result = seen.contains(l);
        seen.add(l);
        return result;
    }
}
