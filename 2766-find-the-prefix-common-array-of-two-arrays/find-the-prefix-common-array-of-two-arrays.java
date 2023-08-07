class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] res = new int[A.length];
        int[] freq = new int[A.length + 1];
        int cnt = 0;
        for(int i = 0; i < A.length; i++) {
            freq[A[i]] += 1;
            freq[B[i]] += 1;
            if(freq[A[i]] == 2) cnt++;
            if(A[i] != B[i] && freq[B[i]] == 2) cnt++;
            res[i] = cnt;
        }
        return res;
    }
}