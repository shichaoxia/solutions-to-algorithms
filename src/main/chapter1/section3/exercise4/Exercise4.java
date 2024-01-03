package chapter1.section3.exercise4;

import chapter1.section3.Stack;

public class Exercise4 {
    public static boolean parentheses(String input) {
        Stack<String> s = new Stack<>();
        for (String c : input.split("")) {
            if (s.isEmpty()) {
                s.push(c);
                continue;
            }
            if (match(s.peek(), c)) {
                s.pop();
                continue;
            }
            s.push(c);
        }
        return s.isEmpty();
    }

    private static boolean match(String l, String r) {
        String pair = l + r;
        return pair.equals("()")
                || pair.equals("[]")
                || pair.equals("{}");
    }
}
