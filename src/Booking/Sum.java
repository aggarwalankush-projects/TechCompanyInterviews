package Booking;

import java.util.*;

public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum=sc.nextInt();
        int num=sc.nextInt();
        int[] array=new int[num];
        for (int i = 0; i < num; i++) {
            array[i]=sc.nextInt();
        }
        findPair(array, sum);

    }

    private static void findPair(int[] array, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                System.out.println("1");
                return;
            } else {
                map.put(k - array[i], i);
            }
        }
        System.out.println("0");
    }
}
