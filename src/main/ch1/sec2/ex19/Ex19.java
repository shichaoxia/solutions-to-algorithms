package ch1.sec2.ex19;


public class Ex19 {
    public static class Date {
        private final int month;
        private final int day;
        private final int year;


        public Date(String date) {
            String[] fields = date.split("/");
            month = Integer.parseInt(fields[0]);
            day = Integer.parseInt(fields[1]);
            year = Integer.parseInt(fields[2]);
        }

        @Override
        public String toString() {
            return month + "/" + day + "/" + year;
        }
    }

    public static class Transaction {
        private final String who;
        private final Date when;
        private final double amount;


        public Transaction(String transaction) {
            String[] a = transaction.split("\\s+");
            who = a[0];
            when = new Date(a[1]);
            amount = Double.parseDouble(a[2]);
        }

        @Override
        public String toString() {
            return String.format("%-10s %10s %8.2f", who, when, amount);
        }
    }

}
