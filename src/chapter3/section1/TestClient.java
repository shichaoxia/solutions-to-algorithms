package chapter3.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestClient {
    @SuppressWarnings({"DuplicatedCode", "Convert2Diamond"})
    public static void main(String[] args) {
        ST<String, Integer> st;
        st = new ST<String, Integer>() {
            @Override
            public void put(String s, Integer val) {

            }

            @Override
            public Integer get(String s) {
                return null;
            }

            @Override
            public void delete(String s) {

            }

            @Override
            public boolean contains(String s) {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public Iterable<String> keys() {
                return null;
            }
        };
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
