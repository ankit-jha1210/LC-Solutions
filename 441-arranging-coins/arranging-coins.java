class Solution {

    public int arrangeCoins(int n) {
        long low = 0, high = n;
        while (low <= high) {
            long k = low + (high - low) / 2;
            long total = k * (k + 1) / 2;
            if (total == n) return (int) k; 
            else if (total < n) low = k + 1; 
            else high = k - 1;
        }
        return (int)high;
    }
}
