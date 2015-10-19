package Booking;

import java.util.Scanner;

public class Polygon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int square = 0, rectangle = 0, polygon = 0;
        for (int i = 0; i < cases; i++) {
            int a, b, c, d;
            a = Integer.parseInt(sc.next());
            b = Integer.parseInt(sc.next());
            c = Integer.parseInt(sc.next());
            d = Integer.parseInt(sc.next());

            if (a <= 0 || a > 2000 || b <= 0 || b > 2000 || c <= 0 || c > 2000 || d <= 0 || d > 2000) {
                polygon++;
                continue;
            }

            if (a == c && b == d) {
                if (a == b)
                    square++;
                else
                    rectangle++;
            }else
                polygon++;
        }


        System.out.println(square + " " + rectangle + " " + polygon);
    }
}
