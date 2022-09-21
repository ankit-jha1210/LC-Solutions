class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        int dist = 0;
        int[][] res = new int[m][n];
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0;i<size;i++) {
                int[] coordinate = q.poll();
                int x = coordinate[0];
                int y = coordinate[1];
                res[x][y] = dist;
                for(int j = 0;j<4;j++) {
                    if(x + dx[j] < 0 || x + dx[j] == m || y + dy[j] < 0 || y + dy[j] == n || visited[x+dx[j]][y + dy[j]]) continue;
                    q.add(new int[] {dx[j] + x, dy[j]+y});
                    visited[dx[j]+x][dy[j]+y] = true;
                }
            }
                dist++;
        }
            return res;
    }
}