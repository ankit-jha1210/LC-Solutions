class Solution {
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, 1, -1 };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    void dfs(int[][] image, int sr, int sc, int origColor, int newColor) {
        image[sr][sc] = newColor;

        for (int i = 0; i < 4; i++) {
            int x = dx[i] + sr;
            int y = dy[i] + sc;
            if (x < 0 || y < 0 || x == image.length || y == image[0].length || image[x][y] != origColor) continue;

            dfs(image, x, y, origColor, newColor);
        }
    }
}
