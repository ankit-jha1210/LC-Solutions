class Solution {
    int[] dx = { 1, -1, 0, 0 };
    int[] dy = { 0, 0, 1, -1 };

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, word, 0, i, j)) return true;
                }
            }
        }
        return false;
    }

    boolean search(char[][] board, String word, int ind, int i, int j) {
        if (ind == word.length()) return true;
        if (i == board.length || j == board[0].length || i < 0 || j < 0 || board[i][j] == '@') return false;
        char ch = board[i][j];
        board[i][j] = '@';
        for (int idx = 0; idx < 4; idx++) {
            // boolean notTake = search(board, word, ind, i + dx[idx], j + dy[idx]);
            // if (notTake) {
            //     board[i][j] = ch;
            //     return true;
            // }
            boolean take = false;
            if (ch == word.charAt(ind)) take = search(board, word, ind + 1, i + dx[idx], j + dy[idx]);
            if (take) {
                board[i][j] = ch;
                return true;
            }
        }
        board[i][j] = ch;
        return false;
    }
}
