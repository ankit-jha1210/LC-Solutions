class Solution {

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '$') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    void dfs(char[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        if (x < 0 || y < 0 || x == m || y == n || board[x][y] != 'O') return;
        board[x][y] = '$';
        dfs(board, x + 1, y);
        dfs(board, x, y + 1);
        dfs(board, x - 1, y);
        dfs(board, x, y - 1);
    }
}
