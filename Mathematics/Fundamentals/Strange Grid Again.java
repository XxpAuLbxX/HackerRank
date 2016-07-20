import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long r = scan.nextLong();
        int c = scan.nextInt();
        long num = (r%2 == 0) ? ((r-2)/2)*10 + 2*(c-1) + 1 : ((r-1)/2)*10 + 2*(c-1);
        System.out.println(num);
    }
}