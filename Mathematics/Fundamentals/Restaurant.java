import java.io.*;
import java.util.*;

public class Solution {
    // find GCD for max square size
    public static int gcd(int a, int b) {
        if(a == 0 || b == 0) return a+b;
        return gcd(b,a%b);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(), l, b, maxCut, squares;
        for(int i = 0; i < T; i++) {
            l = scan.nextInt();
            b = scan.nextInt();
            maxCut = gcd(l,b);
            // Area of bread / area of cut for total number of squares
            squares = (l * b) / (maxCut * maxCut);
            System.out.println(squares);
        }
    }
}