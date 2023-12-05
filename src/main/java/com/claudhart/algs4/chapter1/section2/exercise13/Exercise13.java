package com.claudhart.algs4.chapter1.section2.exercise13;

import edu.princeton.cs.algs4.Date;

@SuppressWarnings("unused")
public class Exercise13 {
    @SuppressWarnings("DuplicatedCode")
    public static class Transaction implements Comparable<Transaction> {
        private final String who; // customer
        private final Date when; // date
        private final double amount; // amount

        @SuppressWarnings("unused")
        public Transaction(String who, Date when, double amount) {
            if (Double.isNaN(amount) || Double.isInfinite(amount))
                throw new IllegalArgumentException("Amount cannot be NaN or infinite");
            this.who = who;
            this.when = when;
            this.amount = amount;
        }

        @SuppressWarnings("unused")
        public Transaction(String transaction) {
            String[] a = transaction.split("\\s+");
            who = a[0];
            when = new Date(a[1]);
            amount = Double.parseDouble(a[2]);
            if (Double.isNaN(amount) || Double.isInfinite(amount))
                throw new IllegalArgumentException("Amount cannot be NaN or infinite");
        }

        @SuppressWarnings("unused")
        public String who() {
            return who;
        }

        @SuppressWarnings("unused")
        public Date when() {
            return when;
        }

        @SuppressWarnings("unused")
        public double amount() {
            return amount;
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
}
