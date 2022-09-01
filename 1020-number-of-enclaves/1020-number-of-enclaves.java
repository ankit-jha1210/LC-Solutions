class Solution {
    int[] dy = { 1, -1, 0, 0 };
    int[] dx = { 0, 0, 1, -1 };

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && grid[i][j] == 1) {
                    q.add(new int[] { i, j });
                    grid[i][j] = 2;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0], y = node[1];
            for (int i = 0; i < 4; i++) {
                int r = x + dy[i];
                int c = y + dx[i];
                if (r < 0 || c < 0 || r == m || c == n || grid[r][c] != 1) continue;
                grid[r][c] = 2;
                q.add(new int[]{r, c});
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) cnt++; 
                else if (grid[i][j] == 2) grid[i][j] = 1;
            }
        }
        return cnt;
    }
}
