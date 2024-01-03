package chapter3.section1.exercise4;



public class Time implements Comparable<Time> {
    private final int hour;
    private final int minute;
    private final int second;

    public Time(String time) {
        String[] times = time.split(":");
        hour = Integer.parseInt(times[0]);
        minute = Integer.parseInt(times[1]);
        second = Integer.parseInt(times[2]);
    }

    @Override
    public int compareTo(Time o) {
        if (hour < o.hour) return -1;
        if (hour > o.hour) return 1;
        if (minute < o.minute) return -1;
        if (minute > o.minute) return 1;
        return Integer.compare(second, o.second);
    }

    @Override
    public String toString() {
        return String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second);
    }
}
