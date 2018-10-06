import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        int len = s.length();
        int cnt = 0, chk = 0;
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        // Collect frequencies
        for(char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        // Iterate over frequencies to check validity
        for(Integer value : freq.values()) {
            // Set chk to freq value
            if(chk == 0) {
                chk = value;
            } else {
                // Ignore matching
                if(value == chk) {
                    continue;
                // If one off, char can be removed once
                } else if(value == chk + 1 || value == chk - 1) {
                    cnt++;
                // Can remove if only one char
                } else if(value == 1) {
                    cnt++;
                // Check if first value was 1, and update
                } else if(value > 1 && chk == 1) {
                    chk = value;
                    cnt++;
                // Greater than one off
                } else {
                    return "NO";
                }
                if(cnt == 2) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
