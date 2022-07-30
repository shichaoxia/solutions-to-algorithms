package chapter1.section1;

public class Exercise13 {
    public static int[][] transpose(int M, int N, int[][] original) {
        int[][] transposed = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                transposed[i][j] = original[j][i];
            }
        }
        return transposed;
    }
}
