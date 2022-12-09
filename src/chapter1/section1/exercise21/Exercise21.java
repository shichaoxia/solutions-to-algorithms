package chapter1.section1.exercise21;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.StdIn;

public class Exercise21 {
    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();

        while (StdIn.hasNextLine())
            inputs.add(StdIn.readLine());

        List<Record> records = processInputs(inputs);
        printRecords(records);
    }

    static List<Record> processInputs(List<String> inputs) {
        List<Record> records = new ArrayList<>();
        for (String input : inputs) {
            String[] strings = input.trim().split("\\s+");
            records.add(new Record(strings[0], strings[1], strings[2]));
        }
        return records;
    }

    static void printRecords(List<Record> records) {
        printHeader();
        for (Record r : records) {
            System.out.printf("%s %d %d %.3f%n", r.name, r.score, r.total, r.percent);
        }
    }

    static void printHeader() {
        System.out.println("Name Score Total Percent");
    }

    record Record(String name, Integer score, Integer total, Double percent) {
        public Record(String name, String score, String total) {
            this(name, Integer.parseInt(score), Integer.parseInt(total),
                    Double.parseDouble(score) / Double.parseDouble(total));
        }
    }
}
