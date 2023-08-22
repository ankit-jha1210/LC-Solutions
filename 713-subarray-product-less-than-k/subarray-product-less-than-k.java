class Solution {

    public int numSubarrayProductLessThanK(int[] a, int k) {
        if(k <= 1) return 0;
        int ans = 0;
        int pro = 1;
        int i = 0, j = 0;
        while (j < a.length) {
            pro *= a[j];
            while (i < a.length && pro >= k) pro /= a[i++];
            ans += (j - i + 1);
            j++;
        }
        return ans;
    }
}
