package ch3.sec1.ex4;

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
