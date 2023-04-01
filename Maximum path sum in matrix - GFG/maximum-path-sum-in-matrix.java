//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends

class Solution{
    static int maximumPath(int N, int mat[][]) {
        int[][] dp = new int[N][N];
        int max = 0;
        for(int i = 0; i < N; i++) dp[N - 1][i] = mat[N - 1][i];
        
           
           for(int row = N - 2; row >= 0; row--) {
               for(int col = 0; col < N; col++) {
                   int down = dp[row + 1][col];
                   int left =  col > 0 ? dp[row + 1][col - 1] : 0;
                   int right = col == N - 1 ? 0 : dp[row + 1][col + 1];
                   dp[row][col] = Math.max(down, Math.max(left, right)) + mat[row][col];
               }
        }
        
        for(int i = 0; i < N; i++) {
            max = Math.max(max, dp[0][i]);
        }
        return max;
    }
}