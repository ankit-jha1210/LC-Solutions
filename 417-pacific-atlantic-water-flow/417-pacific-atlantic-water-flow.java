class Solution {

    //      BruteForce
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachPacific(heights, i, j) && canReachAtlantic(heights, i, j)) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    boolean canReachPacific(int[][] heights, int r, int c) {
        int m = heights.length;
        int n = heights[0].length;
        if (r == 0 || c == 0) return true;
        if (heights[r][c] == -1) return false;
        boolean flag = false;
        int val = heights[r][c];
        heights[r][c] = -1;
        if (heights[r - 1][c] <= val) {
            flag = canReachPacific(heights, r - 1, c);
        }
        if (!flag && r + 1 < m && heights[r + 1][c] <= val) {
            flag = canReachPacific(heights, r + 1, c);
        }
        if (!flag && heights[r][c - 1] <= val) {
            flag = canReachPacific(heights, r, c - 1);
        }
        if (!flag && c + 1 < n && heights[r][c + 1] <= val) {
            flag = canReachPacific(heights, r, c + 1);
        }
        heights[r][c] = val;
        return flag;
    }

    boolean canReachAtlantic(int[][] heights, int r, int c) {
        int m = heights.length;
        int n = heights[0].length;
        if (r == m - 1 || c == n - 1) return true;
        if (heights[r][c] == -1) return false;
        boolean flag = false;
        int val = heights[r][c];
        heights[r][c] = -1;
        if (r - 1 >= 0 && heights[r - 1][c] <= val) {
            flag = canReachAtlantic(heights, r - 1, c);
        }
        if (!flag && r + 1 < m && heights[r + 1][c] <= val) {
            flag = canReachAtlantic(heights, r + 1, c);
        }
        if (c - 1 >= 0 && !flag && heights[r][c - 1] <= val) {
            flag = canReachAtlantic(heights, r, c - 1);
        }
        if (!flag && heights[r][c + 1] <= val) {
            flag = canReachAtlantic(heights, r, c + 1);
        }
        heights[r][c] = val;
        return flag;
    }
}
