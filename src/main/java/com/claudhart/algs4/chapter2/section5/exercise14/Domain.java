package com.claudhart.algs4.chapter2.section5.exercise14;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Domain implements Comparable<Domain> {
    String topLevel;
    String secondLevel;
    String thirdLevel;

    public Domain(String s) {
        String[] parts = s.split("\\.");
        if (parts.length == 3) {
            topLevel = parts[2];
            secondLevel = parts[1];
            thirdLevel = parts[0];
        } else if (parts.length == 2) {
            topLevel = parts[1];
            secondLevel = parts[0];
        } else if (parts.length == 1) {
            topLevel = parts[0];
        }
    }

    public static void main(String[] args) {
        String s = """
                www.google.com
                www.google.co
                www.facebook.com
                www.facebook.co
                cs.princeton.edu
                ee.princeton.edu
                """;

        String[] domainLiterals = s.split("\\s+");
        Domain[] domains = new Domain[domainLiterals.length];
        for (int i = 0; i < domainLiterals.length; i++)
            domains[i] = new Domain(domainLiterals[i]);

        Arrays.sort(domains);
        System.out.println(Arrays.toString(domains));
    }

    @Override
    public String toString() {
        return topLevel + "." + secondLevel + "." + thirdLevel;
    }

    // tag::snippet[]
    @Override
    public int compareTo(@NotNull Domain o) {
        if (topLevel.compareTo(o.topLevel) != 0) {
            return topLevel.compareTo(o.topLevel);
        } else if (secondLevel.compareTo(o.secondLevel) != 0) {
            return secondLevel.compareTo(o.secondLevel);
        } else {
            return thirdLevel.compareTo(o.thirdLevel);
        }
    }
    // end::snippet[]
}
