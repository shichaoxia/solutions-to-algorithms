package chapter1.section3.exercise16;

import java.util.Arrays;

import chapter1.section3.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise16 {

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

        public static Date[] readDates() {
            Queue<Date> q = new Queue<>();
            while (!StdIn.isEmpty())
                q.enqueue(new Date(StdIn.readString()));

            int N = q.size();
            Date[] a = new Date[N];
            for (int i = 0; i < N; i++)
                a[i] = q.dequeue();
            return a;
        }
    }

    public static void main(String[] args) {
        Date[] dates = Date.readDates();
        StdOut.println(Arrays.toString(dates));
    }
}
