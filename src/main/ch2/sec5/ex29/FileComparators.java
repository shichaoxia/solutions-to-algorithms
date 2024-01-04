package ch2.sec5.ex29;

import java.io.File;
import java.util.Comparator;

public class FileComparators {
    public static final Comparator<File> SIZE_ASCENDING = Comparator.comparingLong(File::length);
    public static final Comparator<File> SIZE_DESCENDING = SIZE_ASCENDING.reversed();

    public static final Comparator<File> NAME_ASCENDING = Comparator.comparing(File::getName);
    public static final Comparator<File> NAME_DESCENDING = NAME_ASCENDING.reversed();

    public static final Comparator<File> DATE_ASCENDING = Comparator.comparingLong(File::lastModified);
    public static final Comparator<File> DATE_DESCENDING = DATE_ASCENDING.reversed();
}
