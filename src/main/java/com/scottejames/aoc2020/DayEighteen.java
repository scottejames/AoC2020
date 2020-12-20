package com.scottejames.aoc2020;

import com.scottejames.utils.FileHelper;

import java.util.List;
import java.util.Stack;

public class DayEighteen {
    private static boolean debug = true;

    public static void main(String[] args) {

        FileHelper fh = new FileHelper("2020/DayEighteen.txt");
        List<String> data = fh.getFileAsList();
        long result = 0;

        for (String line : data) {
            if (debug == true) {
                System.out.println("IP " + line);
            }
            Stack<StringBuilder> stack = new Stack<>();
            StringBuilder subExpression = new StringBuilder();

            for (char c : line.toCharArray()) {
                if (c == '(') {
                    stack.push(subExpression);
                    subExpression = new StringBuilder();

                } else if (c == ')') {
                    String ex = subExpression.toString();
                    String p = "" + calcTwo(ex);
                    subExpression = stack.pop();
                    subExpression.append(p);

                } else {
                    subExpression.append(c);
                }
            }
            long res = calcTwo(subExpression.toString());

            if (true == debug) {
                System.out.println("C: " + subExpression.toString() + " = " + res);
            }
            result += res;
        }
        System.out.println(result);
    }



    public static long calc(String ex) {
        String[] c = ex.split(" ");
        long accum = Long.parseLong(c[0]);
        for (int i = 2; i < c.length; i = i + 2) {
            int to = Integer.parseInt(c[i]);
            switch (c[i - 1]) {
                case "+":
                    accum += to;
                    break;
                case "*":
                    accum *= to;
                    break;
            }
        }
        return accum;
    }

    public static long calcTwo(String ex) {
        System.out.println(ex);
        ex = ex.replaceAll("\\s", "");
        String[] c = ex.split("\\*");
        long prod = 1;
        for (String a : c) {
            String[] b = a.split("\\+");
            long sum = 0;
            for (String q : b) {
                sum += Long.parseLong(q);
            }
            prod *= sum;
        }
        return prod;
    }

}
