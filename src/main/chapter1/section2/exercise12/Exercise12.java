package chapter1.section2.exercise12;


public class Exercise12 {
    @SuppressWarnings("DuplicatedCode")
        public record SmartDate(int month, int day, int year) {
            private static final int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public SmartDate {
            if (!isValid(month, day, year))
                throw new IllegalArgumentException("Invalid date");
        }

            // The calculation is shown in
            // https://cs.uwaterloo.ca/~alopez-o/math-faq/node73.html
            public Day dayOfTheWeek() {
                int k = day;
                int m = month <= 2 ? month + 10 : month - 2;
                int C = year / 100;
                int Y = Integer.parseInt(String.valueOf(year).substring(2));
                if (month <= 2)
                    Y -= 1;
                int day = (k + (int) Math.floor(2.6 * m - 0.2) - 2 * C + Y + (int) Math.floor(Y / 4.0)
                        + (int) Math.floor(C / 4.0)) % 7;
                return Day.values()[day];
            }

            @Override
            
            public int month() {
                return month;
            }

            @Override
            
            public int day() {
                return day;
            }

            @Override
            
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

            public enum Day {
                Sunday,
                Monday,
                Tuesday,
                Wednesday,
                Thursday,
                Friday,
                Saturday
            }
        }
}
