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
        int K = sum/2;
        
        boolean[][] dp = new boolean[N][K + 1];
        
        for(int i = 0; i < N; i++) dp[i][0] = true;
        
        if(arr[0] <= K) dp[0][arr[0]] = true;
        
        for(int ind = 1; ind < N; ind++) {
            for(int k = 1; k <= K; k++) {
                boolean not = dp[ind - 1][k];
                
                boolean take = false;
                
                if(arr[ind] <= k) take = dp[ind - 1][k - arr[ind]];
                
                dp[ind][k] =  not || take;
            }
        }
        
        return dp[N - 1][K] ? 1: 0;
    }
}