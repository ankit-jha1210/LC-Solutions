class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[prices.length + 1][2];
        for (int ind = n - 1; ind >= 0; ind--) {
            dp[ind][0] = Math.max(dp[ind + 1][0], dp[ind + 1][1] + prices[ind]);
            dp[ind][1] = Math.max(dp[ind + 1][1], dp[ind + 1][0] - prices[ind]);
        }
        return dp[0][1];
    }
}
