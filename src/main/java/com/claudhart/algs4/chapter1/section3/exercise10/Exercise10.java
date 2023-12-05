package com.claudhart.algs4.chapter1.section3.exercise10;

import java.util.regex.Pattern;

import com.claudhart.algs4.chapter1.section3.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise10 {
    public static String infixToPostfix(String input) throws Exception {
        String[] items = input.split(" ");
        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();
        for (String item : items) {
            if (Pattern.matches("\\d+", item))
                vals.push(item);
            else if (Pattern.matches("[+\\-*/]", item))
                ops.push(item);
            else if (Pattern.matches("\\)", item)) {
                String val2 = vals.pop();
                String val1 = vals.pop();
                String formula = String.format("%s %s %s", val1, val2, ops.pop());
                vals.push(formula);
            } else
                throw new Exception("Unsupported input");
        }
        return vals.pop();
    }

    public static void main(String[] args) {
        try {
            String input = "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )";
            StdOut.println("Infix: " + input);
            String output = infixToPostfix(input);
            StdOut.println("Postfix: " + output);
        } catch (Exception e) {
            StdOut.println(e);
        }
    }
}
