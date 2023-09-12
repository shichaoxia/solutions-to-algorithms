package chapter2.section2.exercise21;


import java.util.Arrays;

public class Triplicates {

    // tag::snippet[]
    public static String findCommonName(String[] list1, String[] list2, String[] list3) {
        Arrays.sort(list1);
        Arrays.sort(list2);
        Arrays.sort(list3);

        int i = 0, j = 0, k = 0;
        String result = null;

        while (i < list1.length && j < list2.length && k < list3.length) {
            if (list1[i].equals(list2[j]) && list1[i].equals(list3[k])) {
                result = list1[i];
                break;
            } else if (list1[i].compareTo(list2[j]) < 0) {
                i++;
            } else if (list2[j].compareTo(list3[k]) < 0) {
                j++;
            } else {
                k++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] list1 = {"Alice", "Bob", "Charlie", "David", "Emma"};
        String[] list2 = {"Bob", "David", "Frank", "Grace", "Hannah"};
        String[] list3 = {"Charlie", "David", "Emily", "Frank", "George"};

        String commonName = findCommonName(list1, list2, list3);

        if (commonName == null) {
            System.out.println("No common name found.");
        } else {
            System.out.println("Common name: " + commonName);
        }
    }
    // end::snippet[]
}

