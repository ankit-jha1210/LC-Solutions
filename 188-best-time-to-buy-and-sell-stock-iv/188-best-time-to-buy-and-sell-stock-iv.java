class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[k+1][prices.length][2];
        return helper(k, prices, 0, 1, dp);
    }
    int helper(int k, int[] prices, int idx, int canBuy, int[][][] dp) {
        if(k == 0 || idx == prices.length) return 0;
        if(dp[k][idx][canBuy] != 0) return dp[k][idx][canBuy];
        int buy = 0, notBuy = 0;
        if(canBuy == 1) buy = -prices[idx] + helper(k, prices, idx+1, 0, dp);
        else notBuy =  helper(k-1, prices, idx+1, 1, dp) + prices[idx];
        return dp[k][idx][canBuy] = Math.max(helper(k, prices, idx+1, canBuy, dp), Math.max(buy, notBuy));
         
    }
}