//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        long[][] dp = new long[N][sum + 1];
        for(long[] row: dp) Arrays.fill(row, -1);
        return solve(coins, 0, sum, dp);
    }
    
    long solve(int[] coins, int ind, int sum, long[][] dp) {
        if(ind == coins.length - 1) {
            if(sum == 0 || sum % coins[ind] == 0) return 1;
            return 0;
        }
        if(dp[ind][sum] != -1) return dp[ind][sum];
        long take = 0;
        
        if(coins[ind] <= sum) take = solve(coins, ind, sum - coins[ind], dp);
        
        long not = solve(coins, ind + 1, sum, dp);
        
        return dp[ind][sum] =  take + not; 
    }
}