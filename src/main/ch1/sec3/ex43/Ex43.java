package ch1.sec3.ex43;

import java.io.File;

import edu.princeton.cs.algs4.StdOut;

public class Ex43 {

    @SuppressWarnings("DataFlowIssue")
    public static void printFiles(int level, File dir) {
        StringBuilder indent = new StringBuilder();
        while (level > 0) {
            indent.append("    ");
            level -= 1;
        }
        String[] names = dir.list();
        for (String name : names) {
            File file = new File(dir, name);
            if (file.isDirectory()) {
                StdOut.println(indent + file.getName() + "/");
                printFiles(level + 1, file);
            } else
                StdOut.println(indent + file.getName());
        }
    }

    public static void main(String[] args) {
        String name = args[0];
        File f = new File(name);
        printFiles(0, f);
    }
}
