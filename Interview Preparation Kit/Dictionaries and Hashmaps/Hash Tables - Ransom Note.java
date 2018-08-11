import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        boolean check = true;
        Hashtable<String, Integer> magaHash = new Hashtable<String, Integer>();
        // Put all values into a hashtable
        for(String s : magazine) {
            // Increase frequency for multiple occurences
            if(magaHash.containsKey(s)) {
                magaHash.put(s, magaHash.get(s) + 1);
            } else {
                magaHash.put(s, 1);
            }
        }
        // Check hashtable for match in note
        for(String s : note) {
            // Remove once found, else note can't be made
            if(null != magaHash.get(s) && magaHash.get(s) > 0) {
                magaHash.put(s, magaHash.get(s) - 1);
            } else {
                System.out.println("No");
                check = false;
                break;
            }
        }
        if(true == check) {
            System.out.println("Yes");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
