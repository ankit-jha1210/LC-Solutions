//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperation(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java


class Solution
{
    // int mod = (int)Math.pow(10, 8);
    public int minOperation(int n)
    {
        Integer[] dp = new Integer[n];
     return solve(1, n, dp) + 1;   
    }
    int solve(int curr, int n, Integer[] dp) {
        
        if(curr == n) return 0;
        if(curr > n) return Integer.MAX_VALUE;
        
        if(dp[curr] != null) return dp[curr];
        int op1 = solve(curr * 2, n, dp);
        int op2 = solve(curr + 1, n, dp);
        return dp[curr] =  Math.min(op1, op2) + 1;
    }
}