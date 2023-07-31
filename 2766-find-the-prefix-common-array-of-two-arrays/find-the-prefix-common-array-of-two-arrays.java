class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        int cnt = 0;
        int[] freq = new int[n + 1];
        for(int i = 0; i < n; i++) {
            if(++freq[A[i]] == 2) cnt++;
            if(++freq[B[i]] == 2) cnt++;
            res[i] = cnt;
        }
        return res;
    }
}