package chapter2.section5.exercise18;

import chapter2.section1.Selection;
import chapter2.section3.Quick;
import chapter2.section4.HeapsortZero;

import java.util.Arrays;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ForceStability {
    public static void stableSort(Comparable[] a, String alg) {
        Wrapper[] wrappers = wrap(a);

        sort(wrappers, alg);

        restoreOrderOfIdenticalElements(wrappers);

        unwrap(a, wrappers);
    }

    public static Wrapper[] wrap(Comparable[] a) {
        Wrapper[] wrappers = new Wrapper[a.length];
        for (int i = 0; i < a.length; i++) {
            wrappers[i] = new Wrapper();
            wrappers[i].original = a[i];
            wrappers[i].index = i;
        }
        return wrappers;
    }

    public static void unwrap(Comparable[] a, Wrapper[] wrappers) {
        for (int i = 0; i < a.length; i++) {
            a[i] = wrappers[i].original;
        }
    }

    public static void restoreOrderOfIdenticalElements(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i - 1]) == 0) {
                int repeatingEnd = identicalElementsRange(a, i);
                int repeatingStart = i - 1;
                restoreOrder(a, repeatingStart, repeatingEnd);
            }
        }
    }

    public static int identicalElementsRange(Comparable[] a, int from) {
        int to = from + 1;
        while (to < a.length && a[to].compareTo(a[to - 1]) == 0) to++;
        return to - 1;
    }

    public static void restoreOrder(Comparable[] a, int from, int to) {
        Arrays.sort(a, from, to + 1, (o1, o2) -> {
            Wrapper w1 = (Wrapper) o1;
            Wrapper w2 = (Wrapper) o2;
            return w1.index - w2.index;
        });
    }

    public static void sort(Comparable[] a, String alg) {
        switch (alg) {
            case "Selection" -> Selection.sort(a);
            case "Quick" -> Quick.sort(a);
            case "Heap" -> HeapsortZero.sort(a);
            default -> throw new IllegalArgumentException("Unknown algorithm: " + alg);
        }
    }

    public static class Wrapper implements Comparable<Wrapper> {
        private Comparable original;
        private int index;

        @Override
        public int compareTo(ForceStability.Wrapper o) {
            return original.compareTo(o.original);
        }
    }
}
