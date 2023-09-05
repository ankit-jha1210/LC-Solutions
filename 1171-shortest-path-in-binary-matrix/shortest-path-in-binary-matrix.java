class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        q.add(new int[] { 0, 0 });
        dist[0][0] = 1;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0], y = node[1];
            if (x == n - 1 && y == n - 1) return dist[x][y];
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int xx = i + x;
                    int yy = j + y;
                    if (xx < 0 || yy < 0 || xx == n || yy == n || grid[xx][yy] == 1) continue;
                    if (dist[x][y] + 1 < dist[xx][yy]) {
                        dist[xx][yy] = dist[x][y] + 1;
                        q.add(new int[] { xx, yy });
                    }
                }
            }
        }
        return -1;
    }
}
