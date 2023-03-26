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


class Solution {
    public long count(int coins[], int N, int sum) {
        long[][] dp = new long[N][sum + 1];
        dp[N - 1][0] = 1;
        for(int i = 1; i <= sum; i++) {
            if(i % coins[N - 1] == 0) dp[N -1][i] = 1;
        }
        
        for(int ind = N - 2; ind >= 0; ind--) {
            
            for(int j = 0; j <= sum; j++) {
                
                long take = 0;
                
                if(coins[ind] <= j) take = dp[ind][j - coins[ind]];
                
                long not = dp[ind + 1][j];
                
                dp[ind][j] =  take + not; 
            }
        }
        return dp[0][sum];
    }
}