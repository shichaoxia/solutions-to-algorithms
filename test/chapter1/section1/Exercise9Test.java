package chapter1.section1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise9Test {
    @Test
    void convertIntToBinaryString() {
        assertEquals("1101", Exercise9.convertIntToBinaryString(13));
    }
}
