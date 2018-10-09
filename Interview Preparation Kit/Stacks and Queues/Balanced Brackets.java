import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> brackets = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            // Push close bracket for easier compare
            switch(s.charAt(i)) {
                case '{':
                    brackets.push('}');
                    break;
                case '[':
                    brackets.push(']');
                    break;
                case '(':
                    brackets.push(')');
                    break;
                case '}':
                case ']':
                case ')':
                    // Check if brackets are balanced 
                    if(brackets.empty() || brackets.pop() != s.charAt(i)) {
                        return "NO";
                    }
                    break;
                default: break;
            }
        }
        // Check if there are any remaining brackets
        if(brackets.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
