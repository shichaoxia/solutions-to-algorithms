package chapter3.section1.exercise4;

import chapter3.section1.BinarySearchST;
import chapter3.section1.OrderedST;

public class Client {
    public static void main(String[] args) {
        OrderedST<Time, Event> st = new BinarySearchST<>(20);
        st.put(new Time("09:00:00"), new Event("Chicago"));
        st.put(new Time("09:00:03"), new Event("Phoenix"));
        st.put(new Time("09:00:13"), new Event("Houston"));
        st.put(new Time("09:00:59"), new Event("Chicago"));
        st.put(new Time("09:01:10"), new Event("Houston"));
        st.put(new Time("09:03:13"), new Event("Chicago"));
        st.put(new Time("09:10:11"), new Event("Seattle"));
        st.put(new Time("09:10:25"), new Event("Seattle"));
        st.put(new Time("09:14:25"), new Event("Phoenix"));
        st.put(new Time("09:19:32"), new Event("Chicago"));
        st.put(new Time("09:19:46"), new Event("Chicago"));
        st.put(new Time("09:21:05"), new Event("Chicago"));
        st.put(new Time("09:22:43"), new Event("Seattle"));
        st.put(new Time("09:22:54"), new Event("Seattle"));
        st.put(new Time("09:25:52"), new Event("Chicago"));
        st.put(new Time("09:35:21"), new Event("Chicago"));
        st.put(new Time("09:36:14"), new Event("Seattle"));
        st.put(new Time("09:37:44"), new Event("Phoenix"));

        System.out.println("min(): " + st.min());
        System.out.println("get(09:00:13): " + st.get(new Time("09:00:13")));
        System.out.println("floor(09:05:00): " + st.floor(new Time("09:05:00")));
        System.out.println("select(7): " + st.select(7));
        System.out.println("keys(09:15:00, 09:25:00):");
        st.keys(new Time("09:15:00"), new Time("09:25:00")).forEach(System.out::println);
        System.out.println("ceiling(09:30:00): " + st.ceiling(new Time("09:30:00")));
        System.out.println("max(): " + st.max());
        System.out.println("size(09:15:00, 09:25:00): " + st.size(new Time("09:15:00"), new Time("09:25:00")));
        System.out.println("rank(09:10:25): " + st.rank(new Time("09:10:25")));

    }
}
