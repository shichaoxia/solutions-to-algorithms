package chapter2.section5.exercise16;

import java.util.Arrays;
import java.util.Comparator;

public class California {
    public static void main(String[] args) {

        @SuppressWarnings("SpellCheckingInspection")
        String[] candidates = {"Turcotte", "Jerde", "Gorczany", "Wiegand", "Rutherford"};

        String[] upperCaseCandidates = Arrays.stream(candidates)
                .map(String::toUpperCase)
                .toArray(String[]::new);

        CandidateOrder candidateOrder = new CandidateOrder();
        for (int i = 0; i < upperCaseCandidates.length; i++) {
            for (int j = i + 1; j < upperCaseCandidates.length; j++) {
                System.out.printf("Compare %s with %s: %d%n",
                        upperCaseCandidates[i],
                        upperCaseCandidates[j],
                        candidateOrder.compare(upperCaseCandidates[i], upperCaseCandidates[j]));
            }
        }
    }

    public static class CandidateOrder implements Comparator<String> {
        @SuppressWarnings("SpellCheckingInspection")
        private static final String ORDER = "RWQOJMVAHBSGZXNTCIEKUPDYFL";

        @Override
        public int compare(String o1, String o2) {
            int min = Math.min(o1.length(), o2.length());
            for (int i = 0; i < min; i++) {
                int index1 = ORDER.indexOf(o1.charAt(i));
                int index2 = ORDER.indexOf(o2.charAt(i));
                if (index1 != index2) {
                    return index1 - index2;
                }
            }
            return o1.length() - o2.length();
        }
    }
}
