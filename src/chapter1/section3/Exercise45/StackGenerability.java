package chapter1.section3.Exercise45;

import java.util.Arrays;
import java.util.regex.Pattern;

import chapter1.section3.Stack;
import edu.princeton.cs.algs4.StdOut;

public class StackGenerability {
    public static boolean willUnderflow(String sequence) {
        int num = 0;
        boolean willUnderflow = false;
        String[] ops = sequence.split(" ");
        for (String op : ops) {
            if (Pattern.matches("\\d+", op))
                num += 1;
            else
                num -= 1;
            if (num < 0) {
                willUnderflow = true;
                break;
            }
        }
        return willUnderflow;
    }

    public static boolean canGenerate(int[] perm) {
        Stack<Integer> stack = new Stack<>();
        Stack<String> ops = new Stack<>();
        int N = perm.length - 1;
        int current = 0;
        for (int i = 0; i <= N; i++) {
            if (i <= perm[current]) {
                stack.push(i);
                ops.push(Integer.toString(i));
            }
            if (i == perm[current]) {
                stack.pop();
                ops.push("-");
                current += 1;
            }
        }
        while (current < perm.length) {
            if (stack.peek() == perm[current]) {
                stack.pop();
                ops.push("-");
                current += 1;
            } else {
                StdOut.println(ops);
                return false;
            }
        }
        StdOut.println(ops);
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 2, 0 };
        int[] b = { 1, 3, 0, 2 };
        System.out.println(Arrays.toString(a) + " can be generated? " + canGenerate(a));
        System.out.println(Arrays.toString(b) + " can be generated? " + canGenerate(b));

        String c = "0 - -";
        String d = "0 1 - -";
        System.out.println(c + " will underflow? " + willUnderflow(c));
        System.out.println(d + " will underflow? " + willUnderflow(d));
    }
}
