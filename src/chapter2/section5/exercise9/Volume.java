package chapter2.section5.exercise9;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Volume {
    LocalDate date;
    int serialNumber;
    long amount;

    public Volume(String v) {
        String regex = "(\\d+)-(\\w+)-(\\d+)\\s+(\\d+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(v);

        if (!matcher.find()) {
            throw new RuntimeException("Initialization failed: no match found.");
        }

        String dayString = matcher.group(1);
        String monthString = matcher.group(2);
        String serialNumberString = matcher.group(3);
        String amountString = matcher.group(4);

        int day = Integer.parseInt(dayString);
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMM");
        Month month;
        try {
            month = Month.from(monthFormatter.parse(monthString));
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Initialization failed: failed to parse month: " + e.getMessage());
        }

        date = LocalDate.of(0, month, day);
        serialNumber = Integer.parseInt(serialNumberString);
        amount = Long.parseLong(amountString);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM");
        String formattedDate = date.format(formatter);
        return formattedDate + "-" + serialNumber + " " + amount;
    }

    public static class AmountOrder implements Comparator<Volume> {
        @Override
        public int compare(Volume v1, Volume v2) {
            return Long.compare(v1.amount, v2.amount);
        }
    }
}
