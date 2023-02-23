//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int mod = (int)Math.pow(10, 9) + 7;
    static int uniquePaths(int n, int m, int[][] grid) {
        Integer[][] dp = new Integer[n][m];
        return solve(grid, 0, 0, dp);
    }
    static int solve(int[][] grid, int i, int j, Integer[][] dp) {
        int n = grid.length, m = grid[0].length;
        if(i == n || j == m || grid[i][j] != 1) return 0;
        
        if(i == n - 1 && j == m - 1) return 1;
        
        if(dp[i][j] != null) return dp[i][j];
        int down = solve(grid, i + 1, j, dp);
        int right = solve(grid, i, j + 1, dp);
        return dp[i][j] = (down + right) % mod;
    }
};