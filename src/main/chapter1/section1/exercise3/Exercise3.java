package chapter1.section1.exercise3;

@SuppressWarnings({"ConditionCoveredByFurtherCondition"})
public class Exercise3 {
    @SuppressWarnings("ConstantValue")
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        boolean result = (a == b) && (b == c) && (c == a);
        String output = result ? "equal" : "not equal";
        System.out.print(output);
    }
}
