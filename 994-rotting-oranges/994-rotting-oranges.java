class Solution {
    int[] dx = { 1, -1, 0, 0 };
    int[] dy = { 0, 0, 1, -1 };

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int total = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
                if (grid[i][j] != 0) total++;
            }
        }
        int time = 0;
        int curr = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] dimension = q.poll();
                curr++;
                for (int j = 0; j < 4; j++) {
                    int x = dimension[0] + dx[j];
                    int y = dimension[1] + dy[j];
                    if (x < 0 || y < 0 || x == rows || y == cols || grid[x][y] != 1) continue;
                    q.add(new int[] { x, y });
                    grid[x][y] = 2;
                }
                // if q is empty that means nothing rotten than we don't have to increase time
            }
                if(!q.isEmpty()) time++;
        }
        return curr == total ? time : -1;
    }
}
