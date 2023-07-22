class Solution {
    public long maxScore(int[] nums, int x) {
        long[][] dp = new long[nums.length + 1][2];
        for(int idx = nums.length - 1; idx > 0; idx--) {
            for(int prev = 0; prev <= 1; prev++) {
                long take = dp[idx + 1][nums[idx] % 2] + nums[idx];
                if(nums[idx] % 2 != prev) take -= x;
                long not = dp[idx + 1][prev];
                dp[idx][prev] = Math.max(take, not);
            }
        }
        return dp[1][nums[0] % 2] + nums[0];
    }
}