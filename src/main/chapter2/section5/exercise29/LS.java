package chapter2.section5.exercise29;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class LS {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java LS <flags>");
            return;
        }

        File directory = new File(".");
        File[] files = directory.listFiles();

        Comparator<File> comparator = null;
        for (String flag : args) {
            switch (flag) {
                case "-s" -> {
                    if (comparator == null) {
                        comparator = FileComparators.SIZE_ASCENDING;
                    } else {
                        comparator = comparator.thenComparing(FileComparators.SIZE_ASCENDING);
                    }
                }
                case "-S" -> {
                    if (comparator == null) {
                        comparator = FileComparators.SIZE_DESCENDING;
                    } else {
                        comparator = comparator.thenComparing(FileComparators.SIZE_DESCENDING);
                    }
                }
                case "-n" -> {
                    if (comparator == null) {
                        comparator = FileComparators.NAME_ASCENDING;
                    } else {
                        comparator = comparator.thenComparing(FileComparators.NAME_ASCENDING);
                    }
                }
                case "-N" -> {
                    if (comparator == null) {
                        comparator = FileComparators.NAME_DESCENDING;
                    } else {
                        comparator = comparator.thenComparing(FileComparators.NAME_DESCENDING);
                    }
                }
                case "-t" -> {
                    if (comparator == null) {
                        comparator = FileComparators.DATE_ASCENDING;
                    } else {
                        comparator = comparator.thenComparing(FileComparators.DATE_ASCENDING);
                    }
                }
                case "-T" -> {
                    if (comparator == null) {
                        comparator = FileComparators.DATE_DESCENDING;
                    } else {
                        comparator = comparator.thenComparing(FileComparators.DATE_DESCENDING);
                    }
                }
                default -> {
                    System.out.println("Invalid flag: " + flag);
                    return;
                }
            }
        }

        Arrays.sort(Objects.requireNonNull(files), comparator);

        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}
