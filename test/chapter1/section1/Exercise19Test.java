package chapter1.section1;

import org.junit.jupiter.api.Test;

public class Exercise19Test {

    static int repetitions = 10;

    @Test
    void testF() {
        long startTime = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            Exercise19.F(i);
        }

        long endTime = System.nanoTime();
        long durationInNano = (endTime - startTime);

        System.out.println(durationInNano);
    }

    @Test
    void testMemorizedF() {
        long startTime = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            Exercise19.memorizedF(i);
        }

        long endTime = System.nanoTime();
        long durationInNano = (endTime - startTime);

        System.out.println(durationInNano);
    }

}
