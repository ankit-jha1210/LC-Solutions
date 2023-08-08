class Solution {

    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, Pair> map = new HashMap<>();
        Map<Integer, Integer> rc = new HashMap<>();
        Map<Integer, Integer> cc = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new Pair(i, j));
            }   
        }
        for (int i = 0; i < arr.length; i++) {
            Pair p = map.get(arr[i]);
            int r = p.first;
            int c = p.second;
            int rowFreq = rc.getOrDefault(r, 0) + 1;
            int colFreq = cc.getOrDefault(c, 0) + 1;
            if (rowFreq == n || colFreq == m) return i;
            rc.put(r, rowFreq);
            cc.put(c, colFreq);
        }
        return -1;
    }
}
