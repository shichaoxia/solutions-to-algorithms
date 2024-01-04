package ch1.sec1.ex11;

public class Ex11 {
    public static void printTwoDimensionalBooleanArray(boolean[][] arr) {
        printColHeader(arr[0].length);
        int rowNum = 1;
        for (boolean[] row : arr) {
            System.out.print(rowNum);
            rowNum += 1;
            for (boolean item : row) {
                if (item) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void printColHeader(int col) {
        System.out.print(" ");
        int i = 1;
        while (col >= i) {
            System.out.print(i);
            i += 1;
        }
        System.out.println();
    }
}
