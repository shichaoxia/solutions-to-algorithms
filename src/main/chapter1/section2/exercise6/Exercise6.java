package chapter1.section2.exercise6;

public class Exercise6 {
    public static boolean circularRotation(String s, String t) {
        boolean isCircularRotation = false;
        for (int i = 0; i < s.length() - 1; i++) {
            String sub1 = s.substring(0, i + 1);
            String sub2 = s.substring(i + 1);
            String cr = sub2 + sub1;
            if (cr.equals(t)) {
                isCircularRotation = true;
                break;
            }
        }
        return isCircularRotation;
    }
}
