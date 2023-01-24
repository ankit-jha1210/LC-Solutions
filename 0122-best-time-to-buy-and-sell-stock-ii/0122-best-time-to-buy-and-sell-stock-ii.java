class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[prices.length + 1][2];
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) {
                    dp[ind][buy] = Math.max(dp[ind + 1][0], dp[ind + 1][1] + prices[ind]);
                } else {
                    dp[ind][buy] = Math.max(dp[ind + 1][1], dp[ind + 1][0] - prices[ind]);
                }
            }
        }
        return dp[0][1];
    }
}
