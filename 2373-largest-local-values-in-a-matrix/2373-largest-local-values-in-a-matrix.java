class Solution {

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                int maxi = Integer.MIN_VALUE;
                for (int i1 = i; i1 < i + 3; i1++) {
                    for (int j1 = j; j1 < j + 3; j1++) {
                        maxi = Math.max(maxi, grid[i1][j1]);
                    }
                }
                res[i][j] = maxi;
            }
        }
        return res;
    }
}
