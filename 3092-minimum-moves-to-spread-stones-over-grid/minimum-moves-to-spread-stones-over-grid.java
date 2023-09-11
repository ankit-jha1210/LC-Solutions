class Solution {

    public int minimumMoves(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) cnt++;
            }
        }
        if (cnt == 0) return 0;
        int moves = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if (grid[k][l] > 1) {
                                grid[k][l]--;
                                grid[i][j]++;
                                int dis = Math.abs(i - k) + Math.abs(j - l);
                                moves = Math.min(moves, dis + minimumMoves(grid));
                                grid[k][l]++;
                                grid[i][j]--;
                            }
                        }
                    }
                }
            }
        }
        return moves;
    }
}
