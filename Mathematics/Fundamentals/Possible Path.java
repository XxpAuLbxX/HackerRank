import java.io.*;
import java.util.*;

public class Solution {
    
    // find GCD
    public static int gcd(int a, int b) {
        if(a == 0 || b == 0) return a+b;
        return gcd(b,a%b);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(), a, b, x, y;
        for(int i = 0; i < T; i++) {
            a = scan.nextInt();
            b = scan.nextInt();
            x = scan.nextInt();
            y = scan.nextInt();
            // if each pair have same GCD there is a solution
            if(gcd(a,b) == gcd(x,y))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}