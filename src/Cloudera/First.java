package Cloudera;

import java.util.Arrays;
import java.util.Collections;

public class First {

    public static void main(String[] args) {
        System.out.println(solution(213));
        System.out.println(solution(553));
    }

    public static int solution(int N) {
        if(N<0||N>10000)
            return N;
        String num=String.valueOf(N);
        if(num.length()==1)
            return Integer.parseInt(num);
        String[] arr=num.split("");
        Arrays.sort(arr, Collections.reverseOrder());
        StringBuilder sb=new StringBuilder();
        for(String s:arr)
        sb.append(s);
        return Integer.parseInt(sb.toString());


    }
}