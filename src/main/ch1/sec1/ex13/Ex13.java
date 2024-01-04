package ch1.sec1.ex13;

public class Ex13 {
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
