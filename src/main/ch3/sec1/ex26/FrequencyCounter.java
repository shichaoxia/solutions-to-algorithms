package ch3.sec1.ex26;

import ch3.sec1.BinarySearchST;
import ch3.sec1.ST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FrequencyCounter {

    
    final int minLen;
    final ST<String, Integer> st;
    final File file;
    final String[] list;


    public FrequencyCounter(int minLen, String file, ST<String, Integer> st, String[] list) {
        this.minLen = minLen;
        this.file = new File(file);
        this.st = st;
        this.list = list;
    }


    public void count() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (!onList(word)) continue;
                if (st.contains(word)) st.put(word, st.get(word) + 1);
                else st.put(word, 1);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean onList(String word) {
        for (String s : list)
            if (s.equals(word)) return true;
        return false;
    }

    /********* Test Client *********/

    public static void main(String[] args) {
        String[] a = {"the", "of", "and", "to", "a", "in", "for", "is", "on", "that"};
        FrequencyCounter fc = new FrequencyCounter(1, "algs4-data/tale.txt", new BinarySearchST<>(), a);
        fc.count();

        System.out.println("Words in file: " + Arrays.toString(a));

        Map<String, Integer> map = new LinkedHashMap<>();
        for (String word : fc.list)
            map.put(word, fc.st.get(word));
        System.out.println("Sorted in file order: " + map);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println("Sorted by frequency: " + sortedMap);
    }
}
