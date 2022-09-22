class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) lst1.add(nums[i]);
            if (i != n - 1) lst2.add(nums[i]);
        }
        Integer[] dp1 = new Integer[n];
        Integer[] dp2 = new Integer[n];
        return Math.max(solve(lst1, 0, dp1), solve(lst2, 0, dp2));
    }

    int solve(List<Integer> nums, int i, Integer[] dp) {
        if (i == nums.size()) return 0;
        if (dp[i] != null) return dp[i];
        int pick = nums.get(i);
        if (i + 2 < nums.size()) pick += solve(nums, i + 2, dp);
        int notPick = solve(nums, i + 1, dp);
        return dp[i] = Math.max(pick, notPick);
    }
}
