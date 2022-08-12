class Solution {
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) chess[i][j] = '.';
        }
        solve(n, chess, 0);
        return res;
    }

    void solve(int n, char[][] chess, int i) {
        if (i >= n) {
            List<String> lst = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                lst.add(new String(chess[row]));
            }
            res.add(lst);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (canPlace(chess, i, j)) {
                chess[i][j] = 'Q';
                solve(n, chess, i + 1);
                chess[i][j] = '.';
            }
        }
    }

    boolean canPlace(char[][] grid, int i, int j) {
        for (int col = 0; col < grid.length; col++) {
            if (grid[i][col] == 'Q') return false;
        }
        for (int row = 0; row <= i; row++) {
            if (grid[row][j] == 'Q') return false;
        }
        for (int row = i, col = j; row >= 0 && col >= 0; row--, col--) {
            if (grid[row][col] == 'Q') return false;
        }
        for (int row = i, col = j; row >= 0 && col < grid.length; row--, col++) {
            if (grid[row][col] == 'Q') return false;
        }
        return true;
    }
}
