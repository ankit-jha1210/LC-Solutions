class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2 * k + 1];
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int transaction = 1; transaction <= 2 * k; transaction++) {
                int notTake = dp[idx + 1][transaction];
                if (transaction % 2 == 0) {
                    int buy = dp[idx + 1][transaction - 1] - prices[idx];
                    dp[idx][transaction] = Math.max(notTake, buy);
                } else {
                    int sell = dp[idx + 1][transaction - 1] + prices[idx];
                    dp[idx][transaction] = Math.max(sell, notTake);
                }
            }
        }
        return dp[0][2 * k];
    }
}
