class Solution {

    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, grid[0].length - 1);
        }
        for (int i = 0; i < grid[0].length; i++) {
            dfs(grid, 0, i);
            dfs(grid, grid.length - 1, i);
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) ans++; 
                else if (grid[i][j] == 2) grid[i][j] = 1;
            }
        }
        return ans;
    }

    void dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] != 1) return;
        grid[x][y] = 2;
        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
        dfs(grid, x - 1, y);
    }
}
