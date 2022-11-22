package chapter1.section4.exercise34;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HorOrColdTest {

    @Test
    void searchSimTwoLgN() {
        HorOrCold s = new HorOrCold(20, 1);
        assertEquals(1, s.searchSimTwoLgN());
        s = new HorOrCold(20, 20);
        assertEquals(20, s.searchSimTwoLgN());
        s = new HorOrCold(20, 10);
        assertEquals(10, s.searchSimTwoLgN());
        s = new HorOrCold(20, 11);
        assertEquals(11, s.searchSimTwoLgN());
        s = new HorOrCold(19, 1);
        assertEquals(1, s.searchSimTwoLgN());
        s = new HorOrCold(19, 10);
        assertEquals(10, s.searchSimTwoLgN());
        s = new HorOrCold(19, 10);
        assertEquals(10, s.searchSimTwoLgN());
        s = new HorOrCold(19, 11);
        assertEquals(11, s.searchSimTwoLgN());
    }

    @Test
    void searchSimOneLgN() {
        HorOrCold s = new HorOrCold(20, 1);
        assertEquals(1, s.searchSimOneLgN());
        s = new HorOrCold(20, 20);
        assertEquals(20, s.searchSimOneLgN());
        s = new HorOrCold(20, 10);
        assertEquals(10, s.searchSimOneLgN());
        s = new HorOrCold(20, 11);
        assertEquals(11, s.searchSimOneLgN());
        s = new HorOrCold(19, 1);
        assertEquals(1, s.searchSimOneLgN());
        s = new HorOrCold(19, 10);
        assertEquals(10, s.searchSimOneLgN());
        s = new HorOrCold(19, 10);
        assertEquals(10, s.searchSimOneLgN());
        s = new HorOrCold(19, 11);
        assertEquals(11, s.searchSimOneLgN());
    }

}