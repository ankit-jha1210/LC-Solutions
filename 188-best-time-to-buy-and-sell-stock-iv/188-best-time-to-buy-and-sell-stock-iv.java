class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2*k+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(2*k, prices, 0, dp);
    }
    int solve(int transaction, int[] prices, int idx, int[][] dp) {
        if(idx == prices.length || transaction == 0) return 0;
        if(dp[idx][transaction] != -1) return dp[idx][transaction];
        int notTake = solve(transaction, prices, idx+1, dp);
        if(transaction % 2 == 0) {
            int buy = solve(transaction-1, prices, idx+1, dp) - prices[idx];
            return dp[idx][transaction] = Math.max(notTake, buy);
        }
        else {
            int sell = solve(transaction-1, prices, idx+1, dp) + prices[idx];
            return dp[idx][transaction] = Math.max(sell, notTake);
        }
    }
}