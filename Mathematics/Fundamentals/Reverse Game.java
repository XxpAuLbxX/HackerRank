import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(), N, K;
        int[] reverse;
        for(int i = 0; i < T; i++) {
            N = scan.nextInt();
            K = scan.nextInt();
            reverse = new int[N];
            for(int j = 0; j < N; j++) {
                if(j%2 == 0) {
                    reverse[j] = N-1-(j/2);
                } else {
                    reverse[j] = (j/2);
                }
            }
            System.out.println(reverse[K]);
        }
    }
}