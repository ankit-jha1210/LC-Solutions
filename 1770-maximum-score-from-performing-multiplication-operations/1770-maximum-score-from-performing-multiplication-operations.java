class Solution {

    public int maximumScore(int[] nums, int[] muls) {
        int m = muls.length, n = nums.length;
        int[] fwd = new int[m + 1];
        for (int l = m - 1; l >= 0; l--) {
            int[] curr = new int[m + 1];
            for (int i = m - 1; i >= 0; i--) {
                if (l > i) break;
                int left = fwd[i + 1] + nums[l] * muls[i];
                int right = curr[i + 1] + nums[n - (i - l) - 1] * muls[i];
                curr[i] = Math.max(left, right);
            }
            fwd = curr;
        }
        return fwd[0];
    }
}
