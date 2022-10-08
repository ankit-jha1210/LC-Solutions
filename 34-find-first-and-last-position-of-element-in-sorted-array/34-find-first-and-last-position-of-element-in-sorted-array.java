class Solution {

    public int[] searchRange(int[] nums, int target) {
        return new int[] { bs(nums, true, target), bs(nums, false, target) };
    }

    int bs(int[] nums, boolean isFirstOcurrence, int target) {
        int low = 0, high = nums.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) low = mid + 1; else if (nums[mid] > target) high = mid - 1;
            else {
                ans = mid;
                if (isFirstOcurrence) high = mid - 1; 
                else low = mid + 1;
            }
        }
        return ans;
    }
}
