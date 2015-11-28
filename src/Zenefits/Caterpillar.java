package Zenefits;

import java.util.Arrays;
import java.util.HashSet;


public class Caterpillar {

    public static void main(String[] args) {
        System.out.println(countUneatenLeaves(10, new int[]{2, 4, 5}));
    }

    static int countUneatenLeaves(int N, int[] A) {
        int balanceN = N;
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {

            int gcd = A[i];
            for (int j = 0; j <= i && balanceN > 0; j++) {
                gcd = findGCD(A[j], A[i]);
                if (gcd > 1 && gcd < A[i]) {
                    break;
                }
            }
            if (gcd == A[i]) {
                balanceN = balanceN - (N / A[i]);
                HashSet<Integer> commonMultiples = new HashSet<Integer>();
                for (int j = 0; j < i; j++) {
                    int lcm = lcm(A[j], A[i]);

                    while (lcm <= N) {
                        commonMultiples.add(lcm);
                        lcm += lcm;

                    }
                }
                balanceN += commonMultiples.size();
            }

        }
        return balanceN;

    }

    private static int lcm(int a, int b) {
        return a * (b / findGCD(a, b));
    }

    private static int findGCD(int number1, int number2) {
        // base case
        if (number2 == 0) {
            return number1;
        }

        return findGCD(number2, number1 % number2);
    }

    // static int countUneatenLeaves(int N, int[] A) {
    // if (N <= 0 || A == null || A.length < 1)
    // return 0;
    // int count = N;
    // Arrays.sort(A);
    // for (int i = 0; i < A.length; i++) {
    // if (!moveForward(A, i,count))
    // continue;
    // count -= N / A[i];
    // count += findCommons(A, i, N);
    // }
    // return count;
    // }
    //
    // static int findCommons(int[] array, int index, int N) {
    // HashSet<Integer> set = new HashSet<>();
    // int elem = array[index];
    // for (int i = 0; i < index; i++) {
    // int l = lcm(elem, array[i]);
    // while (l <= N) {
    // set.add(l);
    // l += l;
    // }
    // }
    // return set.size();
    // }
    //
    // static boolean moveForward(int[] array, int index,int count) {
    // int elem = array[index];
    //// for (int i = 0; i < index&&count>0; i++) {
    //// elem=gcd(elem, array[i]);
    //// if(elem>1&&elem<)
    //// }
    //// return true;
    //
    //
    // int q=array[index];
    // for (int j = 0; j <=index && count>0; j++) {
    // q = gcd(array[j],elem);
    // if (q>1&& q<elem){
    // return false;
    // }
    // }
    // return true;
    //
    //
    // }
    //
    // static int lcm(int a, int b) {
    // return a * (b / gcd(a, b));
    // }
    //
    // static int gcd(int a, int b) {
    // if (b == 0)
    // return a;
    // return gcd(b, a % b);
    // }
}

// if(N<=0||A==null || A.length<1)
// return 0;
// BitSet bs = new BitSet(N);
// for (int i : A) {
// int j = i;
// while (j <= N) {
// bs.set(j);
// j += i;
// }
// }
// int count = 0;
// for (int i = bs.nextSetBit(0); i >= 0; i = bs.nextSetBit(i + 1))
// count++;
// return N - count;
//
// }