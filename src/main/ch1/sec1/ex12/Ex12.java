package ch1.sec1.ex12;

public class Ex12 {
    public static int[] solution() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        return a;
    }
}
