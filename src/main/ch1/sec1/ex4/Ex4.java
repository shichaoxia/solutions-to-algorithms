package ch1.sec1.ex4;

public class Ex4 {
    public static int solution(int a, int b) {
        int c = 1;
        // a
        // Cannot resolve symbol 'then'
    //    if (a > b) then c = 0;

        // b
        // Not a statement
    //    if a > b { c = 0; }

        // c
        if (a > b) c = 0;

        // d
        // ';' expected
    //    if (a > b) c = 0 else b = 0;

        return c;
    }
}
