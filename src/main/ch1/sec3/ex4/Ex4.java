package ch1.sec3.ex4;

import ch1.sec3.Stack;

public class Ex4 {
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
