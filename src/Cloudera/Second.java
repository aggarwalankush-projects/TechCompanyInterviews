package Cloudera;

public class Second {

    public static void main(String[] args) {
        System.out.println(solution(-4, 1, 2, 6, 0, -1, 4, 3));
    }

    public static int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
        long area = (M - K) * (N - L) + (R - P) * (S - Q);
        if (!(M < P || K > R) && !(S < L || Q > N)) {
            int x1 = Math.min(R, M);
            int x2 = Math.max(P, K);
            int y1 = Math.min(S, N);
            int y2 = Math.max(Q, L);
            long overlapArea = (x1 - x2) * (y1 - y2);
            area -= overlapArea;
        }
        if (area > Integer.MAX_VALUE)
            return -1;
        return (int) area;
    }
}