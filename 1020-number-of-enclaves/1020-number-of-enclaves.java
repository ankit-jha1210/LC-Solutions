class Solution {
    int[] dy = { 1, -1, 0, 0 };
    int[] dx = { 0, 0, 1, -1 };

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(grid, 0, i);
            dfs(grid, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) cnt++; 
                else if (grid[i][j] == 2) grid[i][j] = 1;
            }
        }
        return cnt;
    }

    void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] != 1) return;
        grid[i][j] = 2;
        for (int ind = 0; ind < 4; ind++) {
            int r = i + dy[ind];
            int c = j + dx[ind];
            dfs(grid, r, c);
        }
    }
}
