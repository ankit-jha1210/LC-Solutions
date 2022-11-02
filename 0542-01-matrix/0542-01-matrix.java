class Solution {
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length, n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] crd = q.poll();
                mat[crd[0]][crd[1]] = dist;
                for (int j = 0; j < 4; j++) {
                    int x = crd[0] + dx[j];
                    int y = crd[1] + dy[j];
                    if(x < 0 || y < 0 || x == m || y == n) continue;
                    if (!visited[x][y]) {
                        q.add(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}
