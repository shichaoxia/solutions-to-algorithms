package chapter2.section5.exercise20;

import java.util.Comparator;

public class Job {
    public int startTime;
    public int endTime;

    public Job(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Job(String s) {
        String[] times = s.split(" ");
        this.startTime = Integer.parseInt(times[0]);
        this.endTime = Integer.parseInt(times[1]);
    }

    public int duration() {
        return endTime - startTime;
    }

    @Override
    public String toString() {
        return "{" + startTime + ", " + endTime + "}";
    }

    public static class StartOrder implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            return o1.startTime - o2.startTime;
        }
    }
}
