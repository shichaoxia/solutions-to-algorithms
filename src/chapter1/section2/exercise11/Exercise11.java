package chapter1.section2.exercise11;

public class Exercise11 {
    public static class SmartDate {
        private static final int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        private final int month;
        private final int day;
        private final int year;

        public SmartDate(int month, int day, int year) {
            if (!isValid(month, day, year))
                throw new IllegalArgumentException("Invalid date");
            this.month = month;
            this.day = day;
            this.year = year;
        }

        public int month() {
            return month;
        }

        public int day() {
            return day;
        }

        public int year() {
            return year;
        }

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
