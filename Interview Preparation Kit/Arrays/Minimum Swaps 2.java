import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int[] swap_arr = arr.clone();
        int swap_cnt = 0;
        int len = swap_arr.length;
        for(int i = 0; i < len; i++) {
            // Skip sorted numbers
            if(swap_arr[i] == i+1) {
                continue;
            }
            // Swap
            int tmp = swap_arr[i];
            swap_arr[i] = swap_arr[tmp-1];
            swap_arr[tmp-1] = tmp;
            swap_cnt++;
            i--; // Recheck after swap
        }
        return swap_cnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
