class Solution {

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '1') board[i][j] = 'O'; 
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    void dfs(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        if (i < 0 || j < 0 || i == m || j == n || board[i][j] != 'O') return;
        board[i][j] = '1';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
