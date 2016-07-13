import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt(), next;
        int[] b = new int[20];
        for(int i = 0; i < a; i++) {
            next = scan.nextInt();
            if(b[next-1] == 1) {
                System.out.println("NO");
                System.exit(0);
            }
            else {
                b[next-1] = 1;
            }
        }
        System.out.println("YES");
    }
}