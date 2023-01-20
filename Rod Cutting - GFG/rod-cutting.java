//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        Integer[][] dp = new Integer[n + 1][n];
        return solve(price, n, n - 1, dp);
    }
    int solve(int[] price, int n, int ind, Integer[][] dp) {
        if(ind == 0) return n * price[0];
        int rodLength = ind + 1;
        if(dp[n][ind] != null) return dp[n][ind];
        int not = solve(price, n, ind - 1, dp);
        int take = Integer.MIN_VALUE;
        if(rodLength <= n) take = price[ind] + solve(price, n - rodLength, ind, dp);
        return dp[n][ind] = Math.max(take, not);
    }
}