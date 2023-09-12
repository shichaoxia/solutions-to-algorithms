package chapter3.section1;

public interface ST<Key, Value> {
    void put(Key key, Value val);

    Value get(Key key);

    @SuppressWarnings("unused")
    void delete(Key key);

    boolean contains(Key key);

    boolean isEmpty();

    int size();

    Iterable<Key> keys();
}
