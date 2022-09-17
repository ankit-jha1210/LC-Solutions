class Solution {

    public int maximumScore(int[] nums, int[] muls) {
        int m = muls.length, n = nums.length;
        int[][] dp = new int[m + 1][m + 1];
        for (int l = m - 1; l >= 0; l--) {
            for (int i = m - 1; i >= 0; i--) {
                if (l > i) break;
                int left = dp[l + 1][i + 1] + nums[l] * muls[i];
                int right = dp[l][i + 1] + nums[n - (i - l) - 1] * muls[i];
                dp[l][i] = Math.max(left, right);
            }
        }
        return dp[0][0];
    }
    // int solve(int[] nums, int[] muls, int l, int i, Integer[][] dp) {
    //     if (l == nums.length || i == muls.length) return 0;
    //     if (dp[l][i] != null) return dp[l][i];
    //     int left = solve(nums, muls, l + 1, i + 1, dp) + nums[l] * muls[i];
    //     int right = solve(nums, muls, l, i + 1, dp) + nums[nums.length - (i - l) - 1] * muls[i];
    //     return dp[l][i] = Math.max(left, right);
    // }
}
