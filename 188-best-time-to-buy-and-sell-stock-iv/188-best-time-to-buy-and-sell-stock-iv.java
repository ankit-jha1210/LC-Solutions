class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][k + 1][2];
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int j = 1; j <= k; j++) {
                for (int canBuy = 0; canBuy <= 1; canBuy++) {
                    int notTake = dp[idx + 1][j][canBuy];
                    if (canBuy == 1) dp[idx][j][canBuy] = Math.max(-prices[idx] + dp[idx + 1][j][0], notTake); 
                    else dp[idx][j][canBuy] = Math.max(dp[idx + 1][j - 1][1] + prices[idx], notTake);
                }
            }
        }
        return dp[0][k][1];
    }
}
