package Booking;

import java.util.*;

public class Anagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, ArrayList<String>> map = new TreeMap<>();
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input == null || input.length() == 0) break;
            String temp = input.replaceAll("\\s", "");
            String sortInput = sortString(temp);
            if (map.containsKey(sortInput)) {
                map.get(sortInput).add(input);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(input);
                map.put(sortInput, list);
            }
        }

        ArrayList<String> result = new ArrayList<>();
        for (ArrayList<String> arrayList : map.values()) {
            Collections.sort(arrayList);
            StringBuilder sb = new StringBuilder();
            for (String s : arrayList) {
                sb.append(s);
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
        }
        Collections.sort(result);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static String sortString(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);

    }
}
