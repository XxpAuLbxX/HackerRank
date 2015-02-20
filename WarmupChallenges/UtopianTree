import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/* Created class. The Utopian Tree goes through 2 cycles of growth every year. 
 * The first growth cycle occurs during the spring, when it doubles in height. 
 * The second growth cycle occurs during the summer, when its height increases 
 * by 1 meter. The program takes a number of cycles and calculates the height
 * of the tree after the growth cycles.
 */
public class Solution {

    public static void main(String[] args) {
    	// Reads input from STDIN 
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        
        // While there are more numbers
		while(size-- > 0) {
			int numCycles = sc.nextInt();
			int height = 1;
			
			// Calculates height of tree
			for(int i = 1; i <= numCycles; i++) {
				if(i%2 == 0) {
					height += 1;
				} else {
					height *= 2;
				}
			}
			System.out.println(height); 
		}
		sc.close();
    }
}
