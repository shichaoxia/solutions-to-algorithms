package ch3.sec1.ex7;

import ch3.sec1.BinarySearchST;
import ch3.sec1.ST;

public class FrequencyCounter {
    public static void main(String[] args) {
        System.out.printf("%10s%10s%n", "N", "distinct");
        for (int N = 10; N <= 1_000_000; N *= 10) {
            int distinctNum = countRandomDistinctAvg(N, 1000, 10);
            System.out.printf("%10d%10d%n", N, distinctNum);
        }
    }

    public static int countRandomDistinctAvg(int N, int limit, int T) {
        int total = 0;
        for (int i = 0; i < T; i++)
            total += countRandomDistinct(N, limit);
        return total / T;
    }

    public static int countRandomDistinct(int N, int limit) {
        ST<Integer, Integer> st = new BinarySearchST<>(N);
        for (int i = 0; i < N; i++) {
            int input = (int) (Math.random() * limit);
            if (st.contains(input))
                st.put(input, st.get(input) + 1);
            else
                st.put(input, 1);
        }
        return st.size();
    }
}
