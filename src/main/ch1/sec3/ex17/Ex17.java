package ch1.sec3.ex17;

import java.util.Arrays;

import ch1.sec3.Queue;
import ch1.sec3.ex16.Ex16;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex17 {
    public static class Transaction {
        private final String who;
        private final Ex16.Date when;
        private final double amount;

        public Transaction(String transaction) {
            String[] a = transaction.split("\\s+");
            who = a[0];
            when = new Ex16.Date(a[1]);
            amount = Double.parseDouble(a[2]);
        }

        @Override
        public String toString() {
            return String.format("%-10s %10s %8.2f", who, when, amount);
        }

        public static Transaction[] readTransactions() {
            Queue<Transaction> q = new Queue<>();
            String input = StdIn.readAll();
            String[] transactions = input.split(",");
            for (String t : transactions)
                q.enqueue(new Transaction(t.trim()));

            int N = q.size();
            Transaction[] a = new Transaction[N];
            for (int i = 0; i < N; i++)
                a[i] = q.dequeue();
            return a;
        }
    }

    public static void main(String[] args) {
        Transaction[] t = Transaction.readTransactions();
        StdOut.println(Arrays.toString(t));
    }
}
