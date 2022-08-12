class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (solve(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValid(char[][] board, int i, int j, char k) {
        for (int ind = 0; ind < 9; ind++) {
            if (board[ind][j] == k) return false;
            if (board[i][ind] == k) return false;
        }
        int row = i - i % 3, col = j - j % 3;
//         i%3 tells the position in a 3*3 grid and if we subtract from i we get starting row of current grid
//         same is for col
        for(int i1=0;i1<3;i1++){
            for(int j1=0;j1<3;j1++){
                if(board[row+i1][col+j1] == k) return false;
            }
        }
        return true;
    }
}
