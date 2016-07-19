import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(), handshakes;
        for(int i = 0; i < T; i++) {
            handshakes = scan.nextInt();
            // total edges = n(n-1) / 2
            System.out.println(((handshakes - 1) * (handshakes)) / 2);
        }
    }
}