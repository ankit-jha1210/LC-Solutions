class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxi = 1;
        for(int i = 1; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i] && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    maxi = Math.max(dp[i], maxi);
                }
            }
        }
        return maxi;
    }
}