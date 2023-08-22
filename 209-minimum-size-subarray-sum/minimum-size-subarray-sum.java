class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int len = Integer.MAX_VALUE, sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                len = Math.min(len, j - i + 1);
                sum -= nums[i++];
            }
            j++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
