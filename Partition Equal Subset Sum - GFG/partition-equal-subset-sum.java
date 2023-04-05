//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends
class Solution{
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        
        for(int num: arr) sum += num;
        
        if(sum % 2 != 0) return 0;
        int k = sum/2;
        Boolean[][] dp = new Boolean[N][k + 1];
        
        return solve(arr, N - 1, k, dp) ? 1: 0;
    }
    
    static boolean solve(int[] arr, int ind, int k, Boolean[][] dp) {
        
        if(k == 0) return true;
        
        if(ind == 0) {
            if(arr[0] == k) return true;   
            return false;
        }
        if(dp[ind][k] != null) return dp[ind][k];

        boolean not = solve(arr, ind - 1, k, dp);
        
        boolean take = false;
        
        if(arr[ind] <= k) take = solve(arr, ind - 1, k - arr[ind], dp);
        
        return dp[ind][k] =  not || take;
    }
}