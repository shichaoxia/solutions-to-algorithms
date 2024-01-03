package chapter1.section3.exercise9;

import java.util.regex.Pattern;

import chapter1.section3.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise9 {
    // 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
    @SuppressWarnings("StatementWithEmptyBody")
    public static String completeLeftBracket(String input) throws Exception {
        String[] items = input.split(" ");
        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();
        for (String item : items) {
            if (Pattern.matches("\\d+", item))
                vals.push(item);
            else if (Pattern.matches("[+\\-\\*/]", item))
                ops.push(item);
            else if (Pattern.matches("\\(", item)) {
            }
            else if (Pattern.matches("\\)", item)) {
                String val2 = vals.pop();
                String val1 = vals.pop();
                String formula = String.format("( %s %s %s )", val1, ops.pop(), val2);
                vals.push(formula);
            } else
                throw new Exception("Unsupported input");
        }
        return vals.pop();
    }

    public static void main(String[] args) {
        try {
            String input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
            StdOut.println("Incomplete expression: " + input);
            String output = completeLeftBracket(input);
            StdOut.println("Complete left bracket: " + output);
        } catch (Exception e) {
            StdOut.println(e);
        }
    }
}
