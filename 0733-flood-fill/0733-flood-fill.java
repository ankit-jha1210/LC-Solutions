class Solution {
    int[] dx = { 0, 0, 1, -1 };
    int[] dy = { 1, -1, 0, 0 };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    void dfs(int[][] image, int sr, int sc, int color, int orig_color) {
        if (sr < 0 || sc < 0 || sr == image.length || sc == image[0].length || image[sr][sc] != orig_color) return;
        image[sr][sc] = color;
        for (int i = 0; i < 4; i++) {
            int x = sr + dx[i];
            int y = sc + dy[i];
            dfs(image, x, y, color, orig_color);
        }
    }
}
