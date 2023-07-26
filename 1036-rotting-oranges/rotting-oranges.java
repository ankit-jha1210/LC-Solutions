class Solution {
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, 1, -1 };

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
                if(grid[i][j] != 0) total++;
            }
        }
        int time = 0, cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                cnt++;
                int[] dimensions = q.poll();
                for (int x = 0; x < 4; x++) {
                    int xx = dx[x] + dimensions[0];
                    int yy = dy[x] + dimensions[1];
                    if (xx < 0 || yy < 0 || xx == m || yy == n || grid[xx][yy] != 1) continue;
                    q.add(new int[] { xx, yy });
                    grid[xx][yy] = 2;
                }
            }
            if (!q.isEmpty()) time++;
        }
        return cnt == total ? time : -1;
    }
}
