package IndeedPrime;

import java.util.Scanner;

public class CountPerfectSquare {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Lower Limit");
        int low = scan.nextInt();
        System.out.println("Enter Upper Limit");
        int high = scan.nextInt();
        scan.close();

        int smallestNumber = (int)Math.ceil(Math.sqrt(low));
        int highestNumber = (int)Math.floor(Math.sqrt(high));

        System.out.println("Total Number of Perfect square: "+(highestNumber-smallestNumber+1));
    }


}
