package chapter3.section1.exercise1;

import chapter3.section1.ST;
import chapter3.section1.SequentialSearchST;

public class Client {
    public static void main(String[] args) {
        ST<String, Float> st = new SequentialSearchST<>();
        st.put("A+", 4.33f);
        st.put("A", 4.00f);
        st.put("A-", 3.67f);
        st.put("B+", 3.33f);
        st.put("B", 3.00f);
        st.put("B-", 2.67f);
        st.put("C+", 2.33f);
        st.put("C", 2.00f);
        st.put("C-", 1.67f);
        st.put("D", 1.00f);
        st.put("F", 0.00f);

        float total = 0;
        String[] grades = {"A", "B", "C", "D", "F"};
        for (String grade : grades) total += st.get(grade);
        float gpa = total / grades.length;
        assert gpa == 2.5f;
    }
}
