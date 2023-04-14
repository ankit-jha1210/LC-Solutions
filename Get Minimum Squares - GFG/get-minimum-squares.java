//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.MinSquares(n);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int MOD = (int)Math.pow(10, 8);
    public int MinSquares(int n) {
        int i = (int)Math.sqrt(n);
        Integer[][] dp = new Integer[n + 1][i + 1];
        return solve(n, i, dp);
    }
    
    int solve(int n, int i,Integer[][] dp) {
        
        if(n == 0) return 0;
        
        if(n < 0 || i == 0) return MOD;
        
        if(dp[n][i] != null) return dp[n][i];
        int newNum = n - (i * i);
        int take = solve(newNum, i, dp) + 1;
        
        int not = solve(n, i - 1, dp);
        
        return dp[n][i] = Math.min(take, not);
        
    }
}