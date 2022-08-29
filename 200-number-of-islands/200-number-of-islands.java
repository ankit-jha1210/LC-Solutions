class Solution {

    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    void bfs(char[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { r, c });

        grid[r][c] = '0';
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int[] dimensions = q.poll();
            for (int i = 0; i < 4; i++) {
                int i1 = dx[i] + dimensions[0];
                int j1 = dy[i] + dimensions[1];
                if (i1 < 0 || j1 < 0 || i1 == grid.length || j1 == grid[0].length || grid[i1][j1] == '0') continue;
                grid[i1][j1] = '0';
                q.add(new int[] { i1, j1 });
            }
        }
    }
}
