//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.maxSubstring(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int maxSubstring(String s) {
        int maxDiff = 0;
        int zeroes = 0, ones = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') zeroes++;
            else ones++;
            
            int diff = zeroes - ones;
            
            maxDiff = Math.max(maxDiff, diff);
            
            if(diff < 0) {
                zeroes = 0;
                ones = 0;
            }
        }
        return maxDiff == 0 ? -1 : maxDiff;
    }
}