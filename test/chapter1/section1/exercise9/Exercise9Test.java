package chapter1.section1.exercise9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Exercise9Test {
    @Test
    void convertIntToBinaryString() {
        Assertions.assertEquals("1101", Exercise9.convertIntToBinaryString(13));
    }
}
