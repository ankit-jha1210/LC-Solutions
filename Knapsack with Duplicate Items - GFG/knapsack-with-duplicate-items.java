//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int w, int val[], int wt[])
    {
        int[][] dp = new int[N][w + 1];
        for(int j = wt[0]; j <= w; j++) dp[0][j] = val[0] * (j / wt[0]);
        for(int ind = 1; ind < N; ind++){
            for(int W = 1; W <= w; W++) {
                int not = dp[ind - 1][W];
                int take = 0;
                if(wt[ind] <= W) take = dp[ind][W - wt[ind]] + val[ind];
                dp[ind][W] = Math.max(take, not);
            }
        }
        return dp[N - 1][w];
    }
}