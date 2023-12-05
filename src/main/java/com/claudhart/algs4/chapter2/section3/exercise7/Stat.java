package com.claudhart.algs4.chapter2.section3.exercise7;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("rawtypes")
public class Stat {
    public final Map<Comparable, Double> count = new TreeMap<>();

    public static Map<Comparable, Double> getAvgMap(List<Map<Comparable, Double>> maps) {
        Map<Comparable, Double> sumMap = new HashMap<>();
        int numMaps = maps.size();

        // Calculate the sum of values for each key
        for (Map<Comparable, Double> map : maps) {
            for (Map.Entry<Comparable, Double> entry : map.entrySet()) {
                Comparable key = entry.getKey();
                double value = entry.getValue();
                sumMap.put(key, sumMap.getOrDefault(key, 0.0) + value);
            }
        }

        // Calculate the average for each key
        Map<Comparable, Double> avgMap = new TreeMap<>();
        for (Map.Entry<Comparable, Double> entry : sumMap.entrySet()) {
            Comparable key = entry.getKey();
            double sum = entry.getValue();
            double avg = sum / numMaps;
            avgMap.put(key, avg);
        }

        return avgMap;
    }

    public static Map<Comparable, Double> subFirst(Map<Comparable, Double> map, int i) {
        return map.entrySet()
                .stream()
                .limit(i)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, TreeMap::new));
    }

    public void add(Comparable k) {
        if (count.containsKey(k))
            count.put(k, count.get(k) + 1);
        else count.put(k, 1.0);
    }
}
