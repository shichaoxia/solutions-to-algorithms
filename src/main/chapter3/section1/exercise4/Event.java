package chapter3.section1.exercise4;

public class Event {
    private final String name;

    public Event(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
