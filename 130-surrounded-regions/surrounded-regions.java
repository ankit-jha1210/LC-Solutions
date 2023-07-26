class Solution {
    int[] dx = { 1, -1, 0, 0 };
    int[] dy = { 0, 0, 1, -1 };

    public void solve(char[][] board) {
        int m = board.length , n = board[0].length;
        for(int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for(int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '#') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    void dfs(char[][] board, int row, int col) {
        int m = board.length, n = board[0].length;
        if (row < 0 || col < 0 || row == m || col == n || board[row][col] != 'O') return;
        board[row][col] = '#';
        for (int i = 0; i < 4; i++) {
            dfs(board, row + dx[i], col + dy[i]);
        }
    }
}
