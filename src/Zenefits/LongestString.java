package Zenefits;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * find longest string in an array
 * which is made up of strings of same array
 */
public class LongestString {
    public static void main(String... strings) {
        String[] array = {"coat", "rain", "highwayrobber", "dog", "catcher", "dogcatcher", "raincoat"};
        String result = findLongest(array);
        System.out.println("Input array: " + Arrays.toString(array));
        System.out.println("Longest string: " + result);
    }

    public static String findLongest(String[] array) {
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, array);
        String max = "";
        boolean flag = false;
        for (String element : array) {
            String current = element;
            set.remove(current);
            while (current.length() != 0) {
                int j;
                for (j = 0; j < current.length(); j++) {
                    String temp = current.substring(0, j + 1);
                    if (set.contains(temp)) {
                        break;
                    }
                }
                if (j == current.length() - 1) {
                    flag = true;
                    break;
                }
                current = j + 1 < current.length() ? current.substring(j + 1, current.length()) : "";
            }
            if (flag && (element.length() > max.length()))
                max = element;
            set.add(element);
        }
        return max;
    }
}