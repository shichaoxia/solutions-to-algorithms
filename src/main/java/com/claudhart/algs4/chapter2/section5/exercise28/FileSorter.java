package com.claudhart.algs4.chapter2.section5.exercise28;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class FileSorter {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java FileSorter <directory>");
            return;
        }

        File directory = new File(args[0]);
        if (!directory.isDirectory()) {
            System.out.println(args[0] + " is not a directory");
            return;
        }

        File[] files = directory.listFiles();
        Arrays.sort(Objects.requireNonNull(files));

        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}
