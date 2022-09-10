class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] ahead = new int[2 * k + 1];
        for (int idx = n - 1; idx >= 0; idx--) {
            int[] curr = new int[2*k+1];
            for (int transaction = 1; transaction <= 2 * k; transaction++) {
                int notTake = ahead[transaction];
                if (transaction % 2 == 0) {
                    int buy = ahead[transaction - 1] - prices[idx];
                    curr[transaction] = Math.max(notTake, buy);
                } else {
                    int sell = ahead[transaction - 1] + prices[idx];
                    curr[transaction] = Math.max(sell, notTake);
                }
            }
            ahead = curr;
        }
        return ahead[2 * k];
    }
}
