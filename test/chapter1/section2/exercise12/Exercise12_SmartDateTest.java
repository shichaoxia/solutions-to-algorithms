package chapter1.section2.exercise12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import chapter1.section2.exercise12.Exercise12.SmartDate;
import chapter1.section2.exercise12.Exercise12.SmartDate.Day;

public class Exercise12_SmartDateTest {
    @Test
    void testDayOfTheWeek() {
        SmartDate sd1 = new SmartDate(8, 6, 2022);
        assertEquals(sd1.dayOfTheWeek(), Day.Saturday);
        SmartDate sd2 = new SmartDate(1, 17, 2018);
        assertEquals(sd2.dayOfTheWeek(), Day.Wednesday);
    }
}
