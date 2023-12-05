package com.claudhart.algs4.chapter2.section5.exercise12;

import edu.princeton.cs.algs4.MinPQ;

public class SPT {

    final MinPQ<Job> pq = new MinPQ<>();

    public static void main(String[] args) {
        SPT spt = new SPT();
        spt.addJob(new Job("E", 5.0));
        spt.addJob(new Job("A", 1.0));
        spt.addJob(new Job("C", 3.0));
        spt.addJob(new Job("B", 2.0));
        spt.addJob(new Job("D", 4.0));

        while (!spt.pq.isEmpty()) {
            System.out.println(spt.nextJob());
        }
    }

    public void addJob(Job job) {
        pq.insert(job);
    }

    public Job nextJob() {
        return pq.delMin();
    }

    public static class Job implements Comparable<Job> {
        private final String name;
        private final double time;

        public Job(String name, double time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(Job that) {
            return Double.compare(this.time, that.time);
        }

        @Override
        public String toString() {
            return String.format("%s: %.2f", name, time);
        }
    }
}
