class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[k + 1][2];
        for (int idx = n - 1; idx >= 0; idx--) {
            int[][] curr = new int[k+1][2];
            for (int j = 1; j <= k; j++) {
                curr[j][1] = Math.max(-prices[idx] + ahead[j][0], ahead[j][1]);
                curr[j][0] = Math.max(ahead[j - 1][1] + prices[idx], ahead[j][0]);
            }
            ahead = curr;
        }
        return ahead[k][1];
    }
}
