import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(), N, K;
        for(int i = 0; i < T; i++) {
            N = scan.nextInt();
            K = scan.nextInt();
			/* if number over half, list repeats in pattern where every other
			   number from index 0 decreases from N until mid 
			   example: 5 x 4 x 3 */
            if(K >= N/2) {
                System.out.println((N-K-1) * 2);
			/* else number is under half and every other number from index 1
			   increases from 1 until mid (mid excluded)
			   example: x 1 x 2 x*/
            } else {
                System.out.println(K * 2 + 1);
            }
        }
    }
}