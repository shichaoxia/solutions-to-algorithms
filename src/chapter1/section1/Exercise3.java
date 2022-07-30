package chapter1.section1;

public class Exercise3 {
    public static void main(String[] args) {
        Integer a = Integer.parseInt(args[0]);
        Integer b = Integer.parseInt(args[1]);
        Integer c = Integer.parseInt(args[2]);

        Boolean result = (a == b) && (b == c) && (c == a);
        String output = result ? "equal" : "not equal";
        System.out.print(output);
    }
}
