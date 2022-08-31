class Solution {
    int[] dx = { 1, 0, -1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    public List<List<Integer>> pacificAtlantic(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(mat, pacific, i, 0, -1);
            dfs(mat, atlantic, i, n - 1, -1);
        }
        for (int i = 0; i < n; i++) {
            dfs(mat, atlantic, m - 1, i, -1);
            dfs(mat, pacific, 0, i, -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    void dfs(int[][] mat, boolean[][] ocean, int r, int c, int prev) {
        int m = mat.length;
        int n = mat[0].length;
        if (r < 0 || r == m || c < 0 || c == n || ocean[r][c] || mat[r][c] < prev) return;
        ocean[r][c] = true;
        for (int i = 0; i < 4; i++) {
            dfs(mat, ocean, r + dx[i], c + dy[i], mat[r][c]);
        }
    }
}
