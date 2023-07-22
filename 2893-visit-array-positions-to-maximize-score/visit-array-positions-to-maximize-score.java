class Solution {
    public long maxScore(int[] nums, int x) {
        Long[][] dp = new Long[nums.length][2];
        return solve(nums, x, 1, nums[0] % 2, dp) + nums[0];
    }
    long solve(int[] nums, int x, int idx, int prev, Long[][] dp) {
        
        if(idx == nums.length) return 0;
        if(dp[idx][prev] != null) return dp[idx][prev];
        
        long take = solve(nums, x, idx + 1, nums[idx] % 2, dp) + nums[idx];
        
        if(nums[idx] % 2 != prev) take -= x;

        long not = solve(nums, x, idx + 1, prev, dp);
        
        return dp[idx][prev] =  Math.max(take, not);
    }
}