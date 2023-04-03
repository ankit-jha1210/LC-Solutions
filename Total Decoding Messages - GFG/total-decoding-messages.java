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
        int n = str.length();
        int[] dp = new int[n + 1];
        
        dp[n] = 1;
        
        for(int ind = n - 1; ind >= 0; ind--) {
            int firstDigit = str.charAt(ind) - '0';
        
            int cnt = 0;
            if(firstDigit != 0) cnt = dp[ind + 1];
        
        
            if(ind + 1 < str.length()) {
            int secondDigit = (firstDigit * 10) + (str.charAt(ind + 1) - '0');
            if(secondDigit >= 10 && secondDigit <= 26) {
                cnt = (cnt + dp[ind + 2]) % mod;
            }
        }
            dp[ind] = cnt;
            
        }
        return dp[0];
    }
}