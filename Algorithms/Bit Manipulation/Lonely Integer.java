import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
// Completed class
static int lonelyinteger(int[] a) {
    
    boolean flag = false; 
    int first, match;
    // Nested for loops to search through all posibilities
    for(int i = 0; i < a.length; i++) {
        first = a[i];
        for(int j = 0; j < a.length; j++) {
            match = a[j];
            /* Checks if the values match and that
             * they aren't from the same array element */
            if(first == match && i != j) {
                flag = true;
                break;
            } else {
                flag = false;
            }   
        }
        if(!flag)  // Returns if no match found
            return first;
    }
    return 0;
    }
    
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = lonelyinteger(_a);
        System.out.println(res);
        
    }
}

