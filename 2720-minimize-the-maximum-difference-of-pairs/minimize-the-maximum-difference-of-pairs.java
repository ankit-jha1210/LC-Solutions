class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length - 1];
        int ans = -1;
        while(low <= high) {
            int diff = low + (high - low)/2;
            if(isPossible(nums, diff, p)) {
                ans = diff;
                high = diff - 1;
            }
            else low = diff + 1;
        }
        return ans;
    }
    boolean isPossible(int[] nums, int diff, int p) {
        int cnt = 0;
        int i = 1;
        while(i < nums.length) {
            if(nums[i] - nums[i - 1] <= diff) {
                cnt++;
                i += 2;
            }
            else i++;
        }
        return cnt >= p;
    }
}