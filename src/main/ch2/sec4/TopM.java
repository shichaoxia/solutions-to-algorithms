package ch2.sec4;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TopM {
    public static void main(String[] args) {
        // Print the top M lines in the input stream.
        int M = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<>(M + 1);
        while (StdIn.hasNextLine()) {
            // Create an entry from the next line and put on the PQ.
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size() > M)
                // Remove minimum if M+1 entries on the PQ.
                pq.delMin();
        } // Top M entries are on the PQ.
        Stack<Transaction> stack = new Stack<>();
        while (!pq.isEmpty()) stack.push(pq.delMin());
        for (Transaction t : stack) StdOut.println(t);
    }

    
    private static class Transaction implements Comparable<Transaction> {
        private final String who; // customer
        private final Date when; // date
        private final double amount; // amount

        @SuppressWarnings("DuplicatedCode")
        public Transaction(String transaction) {
            String[] a = transaction.split("\\s+");
            who = a[0];
            when = new Date(a[1]);
            amount = Double.parseDouble(a[2]);
            if (Double.isNaN(amount) || Double.isInfinite(amount))
                throw new IllegalArgumentException("Amount cannot be NaN or infinite");
        }

        @Override
        public String toString() {
            return String.format("%-10s %10s %8.2f", who, when, amount);
        }

        public int compareTo(Transaction that) {
            return Double.compare(this.amount, that.amount);
        }

        @Override
        public boolean equals(Object other) {
            if (other == this)
                return true;
            if (other == null)
                return false;
            if (other.getClass() != this.getClass())
                return false;
            Transaction that = (Transaction) other;
            return (this.amount == that.amount) && (this.who.equals(that.who))
                    && (this.when.equals(that.when));
        }

        public int hashCode() {
            int hash = 1;
            hash = 31 * hash + who.hashCode();
            hash = 31 * hash + when.hashCode();
            hash = 31 * hash + ((Double) amount).hashCode();
            return hash;
        }

    }

    
    private static class Date implements Comparable<Date> {
        private final int day;
        private final int month;
        private final int year;

        public Date(String date) {
            String[] fields = date.split("/");
            month = Integer.parseInt(fields[0]);
            day = Integer.parseInt(fields[1]);
            year = Integer.parseInt(fields[2]);
        }

        @SuppressWarnings("UseCompareMethod")
        public int compareTo(Date that) {
            if (this.year > that.year) return +1;
            if (this.year < that.year) return -1;
            if (this.month > that.month) return +1;
            if (this.month < that.month) return -1;
            if (this.day > that.day) return +1;
            if (this.day < that.day) return -1;
            return 0;
        }

        public String toString() {
            return month + "/" + day + "/" + year;
        }
    }
}
