class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                sum -= nums[i];
                len = Math.min(len, j - i + 1);
                i++;
            }
            j++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
