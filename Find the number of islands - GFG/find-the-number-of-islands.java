//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
            }
        }
        
    }
    return islands;
        
    }
    void dfs(char[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] != '1') return;
        grid[row][col] = '2';
        for(int i = 0; i < 8;i++) {
            for(int j = 0; j < 8; j++) {
                dfs(grid, row + dx[i], col + dy[j]);
            }
        }
    }
}