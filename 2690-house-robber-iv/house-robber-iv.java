class Solution {
    public int minCapability(int[] nums, int k) {
        int low = Integer.MAX_VALUE, high = 0;
        for(int num: nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(isPossible(nums, mid, k)) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    boolean isPossible(int[] nums, int max, int k) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= max) {
                k--;
                i++;
            }
            if(k == 0) return true;
        }
        return false;
    }
}