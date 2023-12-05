package com.claudhart.algs4.chapter1.section2.exercise11;

@SuppressWarnings("unused")
public class Exercise11 {
    @SuppressWarnings("DuplicatedCode")
        public record SmartDate(int month, int day, int year) {
            private static final int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        @SuppressWarnings("unused")
        public SmartDate {
            if (!isValid(month, day, year))
                throw new IllegalArgumentException("Invalid date");
        }

            @Override
            @SuppressWarnings("unused")
            public int month() {
                return month;
            }

            @Override
            @SuppressWarnings("unused")
            public int day() {
                return day;
            }

            @Override
            @SuppressWarnings("unused")
            public int year() {
                return year;
            }

            @SuppressWarnings("RedundantIfStatement")
            private static boolean isValid(int m, int d, int y) {
                if (m < 1 || m > 12)
                    return false;
                if (d < 1 || d > DAYS[m])
                    return false;
                if (m == 2 && d == 29 && !isLeapYear(y))
                    return false;
                return true;
            }

            private static boolean isLeapYear(int y) {
                if (y % 400 == 0)
                    return true;
                if (y % 100 == 0)
                    return false;
                return y % 4 == 0;
            }

            @Override
            public String toString() {
                return month + "/" + day + "/" + year;
            }
        }
}
