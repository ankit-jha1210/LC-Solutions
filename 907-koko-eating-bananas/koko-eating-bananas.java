class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        if (h < piles.length) return -1;
        int low = 1, high = 0;
        for (int pile : piles) high = Math.max(high, pile);
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (isPossible(piles, mid, h)) {
                ans = mid;
                high = mid - 1;
            }
             else low = mid + 1;
        }
        return ans;
    }

    boolean isPossible(int[] piles, int k, int h) {
        int hrs = 0;
        for (int pile : piles) {
            hrs += (int)Math.ceil(1.0 * pile / k);
            if (hrs > h) return false;
        }
        return true;
    }
}
