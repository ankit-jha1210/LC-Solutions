class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][k + 1][2];
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int j = 1; j <= k; j++) {
                dp[idx][j][1] = Math.max(-prices[idx] + dp[idx + 1][j][0], dp[idx + 1][j][1]);
                dp[idx][j][0] = Math.max(dp[idx + 1][j - 1][1] + prices[idx], dp[idx + 1][j][0]);
            }
        }
        return dp[0][k][1];
    }
}
