package ch1.sec1.ex15;

public class Ex15 {
    public static int[] histogram(int[] a, int M) {
        int[] b = new int[M];
        for (int i = 0; i < M; i++) {
            b[i] = countOccurrences(a, i);
        }
        return b;
    }
    static int countOccurrences(int[] arr, int target) {
        int total = 0;
        for (int item: arr) {
            if (item == target) total +=1;
        }
        return total;
    }
}
