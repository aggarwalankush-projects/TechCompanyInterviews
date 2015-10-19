package Booking;

import java.util.ArrayList;
import java.util.Scanner;

public class DeltaEncoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> inputList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        String input = sc.nextLine();
        String[] strs = input.split(" ");
        for (String str : strs) {
            inputList.add(Integer.parseInt(str));
        }
        list.add(inputList.get(0));
        for (int i = 1; i < inputList.size(); i++) {
            list.add(inputList.get(i) - inputList.get(i - 1));
        }

        result.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            int element = list.get(i);
            if (element < -127 || element > 127)
                result.add(-128);
            result.add(element);
        }
        for (Integer integer : result) {
            System.out.print(integer+" ");
        }

    }
}
