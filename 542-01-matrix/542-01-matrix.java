class Solution {
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j, 0 });
                    visited[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1], steps = cell[2];
            res[r][c] = steps;
            for (int i = 0; i < 4; i++) {
                if (r + dx[i] >= 0 && r + dx[i] < m && c + dy[i] >= 0 && c + dy[i] < n && !visited[r + dx[i]][c + dy[i]]) {
                    q.add(new int[] { r + dx[i], c + dy[i], steps + 1 });
                    visited[r + dx[i]][c + dy[i]] = true;
                }
            }
        }
        return res;
    }
}
