class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int[][] updateMatrix(int[][] mat) {
        int time = 0;
        int m = mat.length, n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] res = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    q.add(new int[] { i, j });
                }
            }
        }

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] dimensions = q.poll();
                res[dimensions[0]][dimensions[1]] = time;
                for(int j = 0; j < 4; j++) {
                    int x = dx[j] + dimensions[0];
                    int y = dy[j] + dimensions[1];
                    if(x < 0 || y < 0 || x == m || y == n || visited[x][y]) continue;
                    q.add(new int[]{x, y});
                    visited[x][y] =  true;
                }
                
            }
            time++;
        }
        return res;
    }
}
