import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(), Px, Py, Qx, Qy, Symx, Symy;
        for(int i = 0; i < T; i++) {
            Px = scan.nextInt();
            Py = scan.nextInt();
            Qx = scan.nextInt();
            Qy = scan.nextInt();
            Symx = 2*Qx - Px;
            Symy = 2*Qy - Py;
            System.out.println(Symx + " " + Symy);
        }
    }
}