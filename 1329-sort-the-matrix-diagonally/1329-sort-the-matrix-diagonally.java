class Solution {

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < n; i++) {
            countSort(mat, 0, i);
        }
        for (int i = 0; i < m; i++) {
            countSort(mat, i, 0);
        }
        return mat;
    }

    void countSort(int[][] mat, int r, int c) {
        int[] map = new int[101];
        int i = r, j = c;
        int m = mat.length, n = mat[0].length;
        while(i<m && j<n){
            map[mat[i++][j++]]++;
        }
        i = r; j = c;
        for(int idx = 1;idx<=100;idx++){
            while(map[idx] != 0){
                mat[i][j] = idx;
                map[idx]--;
                i++;
                j++;
            }
        }
    }
}
