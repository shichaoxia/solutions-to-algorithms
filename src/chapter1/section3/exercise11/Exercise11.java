package chapter1.section3.exercise11;

import java.util.regex.Pattern;

import chapter1.section3.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise11 {
    public static Integer evaluatePostfix(String input) throws Exception {
        String[] items = input.split(" ");
        Stack<Integer> vals = new Stack<>();
        for (String item : items) {
            if (Pattern.matches("\\d+", item))
                vals.push(Integer.parseInt(item));
            else if (Pattern.matches("[+\\-\\*/]", item)) {
                int val2 = vals.pop();
                int val1 = vals.pop();
                Integer result = null;
                switch (item) {
                    case "+":
                        result = val1 + val2;
                        break;
                    case "-":
                        result = val1 - val2;
                        break;
                    case "*":
                        result = val1 * val2;
                        break;
                    case "/":
                        result = val1 / val2;
                        break;
                    default:
                        break;
                }
                vals.push(result);
            } else
                throw new Exception("Unsupported input");
        }
        return vals.pop();
    }

    public static void main(String[] args) {
        try {
            String input = "1 2 + 3 4 - 5 6 - * *";
            StdOut.println("Postfix: " + input);
            Integer output = evaluatePostfix(input);
            StdOut.println("Evaluated: " + output);
        } catch (Exception e) {
            StdOut.println(e);
        }
    }
}
