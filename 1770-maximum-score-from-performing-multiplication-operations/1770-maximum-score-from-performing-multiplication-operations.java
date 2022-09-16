class Solution {

    public int maximumScore(int[] nums, int[] muls) {
        Integer[][] dp = new Integer[muls.length][muls.length];
        return solve(nums, muls, 0, 0, dp);
    }

    int solve(int[] nums, int[] muls, int i, int l, Integer[][] dp) {
        if (i == muls.length || l == nums.length) return 0;
        if(dp[i][l] != null) return dp[i][l];
        int leftPicked = solve(nums, muls, i + 1, l + 1, dp) + nums[l] * muls[i];
        int rightPicked = solve(nums, muls, i + 1, l, dp) + nums[nums.length - (i - l) - 1] * muls[i];
        return dp[i][l] =  Math.max(leftPicked, rightPicked);
    }
}
