package ch2.sec5.ex20;

import java.util.Arrays;

public class Machine {
    public static int largestIdleInterval(Job[] jobs) {
        Job[] mergedJobs = unionOverlapping(jobs);
        int maxGap = mergedJobs[0].startTime;
        for (int i = 1; i < mergedJobs.length; i++)
            maxGap = Math.max(maxGap, gap(mergedJobs[i - 1], mergedJobs[i]));
        return maxGap;
    }

    public static int largestNonIdleInterval(Job[] jobs) {
        Job[] mergedJobs = unionOverlapping(jobs);
        int maxDuration = 0;
        for (Job mergedJob : mergedJobs)
            maxDuration = Math.max(maxDuration, mergedJob.duration());
        return maxDuration;
    }

    public static void main(String[] args) {
        String s = """
                90 130
                235 295
                275 355
                40 145
                205 345""";
        String[] jobsString = s.split("\n");
        int N = 5;
        Job[] jobs = new Job[N];
        for (int i = 0; i < N; i++)
            jobs[i] = new Job(jobsString[i]);

        Arrays.sort(jobs, new Job.StartOrder());

        System.out.println("Largest idle interval: " + largestIdleInterval(jobs) + ", expected: 60");
        System.out.println("Largest non-idle interval: " + largestNonIdleInterval(jobs) + ", expected: 150");
    }

    public static Job union(Job job1, Job job2) {
        return new Job(Math.min(job1.startTime, job2.startTime), Math.max(job1.endTime, job2.endTime));
    }

    public static boolean isOverlapped(Job job1, Job job2) {
        return job1.startTime <= job2.endTime && job2.startTime <= job1.endTime;
    }

    public static Job[] unionOverlapping(Job[] jobs) {
        Job[] mergedJobs = new Job[jobs.length];
        int j = 0;
        mergedJobs[j] = jobs[0];
        for (int i = 1; i < jobs.length; i++) {
            if (isOverlapped(mergedJobs[j], jobs[i]))
                mergedJobs[j] = union(mergedJobs[j], jobs[i]);
            else
                mergedJobs[++j] = jobs[i];
        }
        if (j < mergedJobs.length - 1) {
            mergedJobs = Arrays.copyOf(mergedJobs, j + 1);
            return mergedJobs;
        }
        return mergedJobs;
    }

    public static int gap(Job job1, Job job2) {
        return job2.startTime - job1.endTime;
    }
}
