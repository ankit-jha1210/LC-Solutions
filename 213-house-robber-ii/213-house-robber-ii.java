class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) lst1.add(nums[i]);
            if (i != n - 1) lst2.add(nums[i]);
        }
        Integer[] dp = new Integer[n];
        return Math.max(solve(lst1, dp), solve(lst2, dp));
    }

    int solve(List<Integer> nums, Integer[] dp) {
        dp[nums.size()] = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            int pick = nums.get(i);
            if (i + 2 < nums.size()) pick += dp[i + 2];
            dp[i] = Math.max(dp[i + 1], pick);
        }
        return dp[0];
    }
}
