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
    static int maximumPath(int N, int Matrix[][]) {
        Integer[][] dp = new Integer[N][N];
        int max = 0;
        for(int i = 0; i < N; i++) {
           max = Math.max(solve(Matrix, 0, i, dp), max);
        }
        return max;
    }
    
    static int solve(int[][] mat, int row, int col, Integer[][] dp) {
        int m = mat.length;
        
        if(col == m || col < 0) return 0;
        
        
        if(row == m - 1) return mat[row][col];
        
        if(dp[row][col] != null) return dp[row][col];
        
        int down = solve(mat, row + 1, col, dp);
        int left = solve(mat, row + 1, col - 1, dp);
        int right = solve(mat, row + 1, col + 1, dp);
        
        return  dp[row][col] = Math.max(down, Math.max(left, right)) + mat[row][col];
    }
}