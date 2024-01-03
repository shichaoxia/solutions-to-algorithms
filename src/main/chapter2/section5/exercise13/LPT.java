package chapter2.section5.exercise13;


import chapter2.section4.MinPQ;

import java.util.Arrays;
import java.util.Collections;


public class LPT {

    public static void main(String[] args) {
        int m = 8;
        int n = 100;
        Job[] jobs = generateJobs(n);
        Arrays.sort(jobs, Collections.reverseOrder());
        Processor[] processors = generateProcessors(m);
        lpt(jobs, processors);
        for (Processor processor : processors)
            System.out.println(processor);
    }

    public static Job[] generateJobs(int n) {
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(i, (int) (Math.random() * 100));
        }
        return jobs;
    }

    public static Processor[] generateProcessors(int m) {
        Processor[] processors = new Processor[m];
        for (int i = 0; i < m; i++) {
            processors[i] = new Processor(i);
        }
        return processors;
    }

    public static void lpt(Job[] jobs, Processor[] processors) {
        MinPQ<Processor> pq = new MinPQ<>(processors.length);
        for (Processor value : processors) {
            pq.insert(value);
        }
        for (Job job : jobs) {
            Processor processor = pq.delMin();
            processor.addJob(job);
            pq.insert(processor);
        }
    }

    public static class Processor implements Comparable<Processor> {
        public final int id;
        public Job[] jobs;
        public int jobCount;

        public Processor(int id) {
            this.id = id;
            jobCount = 0;
            jobs = new Job[1];
        }

        public void addJob(Job job) {
            if (this.jobCount == this.jobs.length) {
                resize(this.jobs.length * 2);
            }
            this.jobs[this.jobCount++] = job;
        }

        public void resize(int capacity) {
            Job[] temp = new Job[capacity];
            System.arraycopy(this.jobs, 0, temp, 0, this.jobs.length);
            this.jobs = temp;
        }

        public int totalTime() {
            int totalTime = 0;
            for (int i = 0; i < this.jobCount; i++) {
                totalTime += this.jobs[i].time;
            }
            return totalTime;
        }

        @Override
        public String toString() {
            return "Processor{" +
                    "id=" + id +
                    ", jobCount=" + jobCount +
                    ", totalTime=" + totalTime() +
                    '}';
        }

        @Override
        public int compareTo(Processor that) {
            return this.totalTime() - that.totalTime();
        }
    }

    public static class Job implements Comparable<Job> {
        private final int id;
        private final int time;

        public Job(int id, int time) {
            this.id = id;
            this.time = time;
        }

        @Override
        public int compareTo(Job that) {
            return that.time - this.time;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "id=" + id +
                    ", time=" + time +
                    '}';
        }
    }
}
