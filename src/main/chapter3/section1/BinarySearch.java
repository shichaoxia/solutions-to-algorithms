package chapter3.section1;


public class BinarySearch<Key extends Comparable<Key>> {
    
    public Key[] keys;

    // tag::snippet[]
    
    public int rank(Key key, int lo, int hi) {
        if (hi < lo) return lo;
        int mid = (lo + hi) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0)
            return rank(key, lo, mid - 1);
        else if (cmp > 0)
            return rank(key, mid + 1, hi);
        else return mid;
    }
    // end::snippet[]
}
