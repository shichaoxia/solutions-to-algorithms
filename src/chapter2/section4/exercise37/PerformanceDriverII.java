package chapter2.section4.exercise37;

import chapter2.section4.MaxPQ;
import edu.princeton.cs.algs4.StdRandom;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class PerformanceDriverII {
    public static void main(String[] args) {
        System.out.printf("%10s %10s%n", "N", "opsNum");
        for (int N = 1_000; N <= 1_000_000; N *= 10) {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            int finalN = N;
            MaxPQ<Double> pq = new MaxPQ<>(finalN);
            AtomicReference<Integer> cnt = new AtomicReference<>(0);
            AtomicBoolean stopFlag = new AtomicBoolean(false);
            try {
                Future<?> future = executorService.submit(() -> trial(pq, finalN, cnt, stopFlag));
                Thread.sleep(1000);
                stopFlag.set(true);
                future.get();
                System.out.printf("%10d %10d%n", N, cnt.get());
                executorService.shutdown();
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void trial(MaxPQ<Double> pq, int N, AtomicReference<Integer> cnt, AtomicBoolean stopFlag) {
        while (!stopFlag.get()) {
            for (int i = 0; i < N; i++) {
                if (stopFlag.get()) break;
                pq.insert(StdRandom.uniform());
                cnt.set(cnt.get() + 1);
            }
            for (int i = 0; i < N; i++) {
                if (stopFlag.get()) break;
                pq.delMax();
                cnt.set(cnt.get() + 1);
            }
        }
    }
}

