class Solution {
    final int mod = (int) Math.pow(10, 9) + 7;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                int ans = 0;
                for (int idx = 1; idx <= k; idx++) {
                    if (idx > j) break;
                    ans = (ans + dp[i - 1][j - idx]) % mod;
                }
                dp[i][j] = ans;
            }
        }
        return dp[n][target];
    }
}
