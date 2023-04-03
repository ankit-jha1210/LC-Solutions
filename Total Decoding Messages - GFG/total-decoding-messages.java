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
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int mod = (int)Math.pow(10, 9) + 7;
    public int CountWays(String str)
    {
        Integer[] dp = new Integer[str.length()];
        return solve(str, 0, dp);
    }
    
    int solve(String str, int ind, Integer[] dp) {
        if(ind == str.length()) return 1;
        
        if(dp[ind] != null) return dp[ind];
        
        int firstDigit = str.charAt(ind) - '0';
        
        int cnt = 0;
        if(firstDigit != 0) cnt = solve(str, ind + 1, dp);
        
        
        if(ind + 1 < str.length()) {
            int secondDigit = (firstDigit * 10) + (str.charAt(ind + 1) - '0');
            if(secondDigit >= 10 && secondDigit <= 26) {
                cnt = (cnt + solve(str, ind + 2, dp)) % mod;
            }
        }
        return dp[ind] = cnt;
    }
}