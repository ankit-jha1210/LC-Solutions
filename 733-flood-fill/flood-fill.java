class Solution {
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, 1, -1 };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    void dfs(int[][] image, int sr, int sc, int prevColor, int color) {
        if (sr < 0 || sc < 0 || sr == image.length || sc == image[0].length) return;
        if (image[sr][sc] != prevColor) return;

        image[sr][sc] = color;
        for (int i = 0; i < 4; i++) {
            int x = dx[i] + sr;
            int y = dy[i] + sc;
            dfs(image, x, y, prevColor, color);
        }
    }
}
