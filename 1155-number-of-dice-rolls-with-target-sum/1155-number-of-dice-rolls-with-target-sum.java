class Solution {
    final int mod = (int)Math.pow(10, 9) + 7;
    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] dp = new Integer[n + 1][target + 1];
        return solve(n, k, target, dp);
    }

    int solve(int n, int k, int target, Integer[][] dp) {
        if (n == 0 && target == 0) return 1;
        if (target == 0 || n == 0) return 0;
        if (dp[n][target] != null) return dp[n][target];
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            if (i > target) break;
            ans = (ans + solve(n - 1, k, target - i, dp)) % mod;
        }
        return dp[n][target] = ans;
    }
}
