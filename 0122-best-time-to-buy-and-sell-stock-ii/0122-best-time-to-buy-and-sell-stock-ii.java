class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ahead0 = 0, ahead1 = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
            int curr0 = 0, curr1 = 0;
            curr0 = Math.max(ahead0, ahead1 + prices[ind]);
            curr1 = Math.max(ahead1, ahead0 - prices[ind]);
            ahead0 = curr0;
            ahead1 = curr1;
        }
        return ahead1;
    }
}
