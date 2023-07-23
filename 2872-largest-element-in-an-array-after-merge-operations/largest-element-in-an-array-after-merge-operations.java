class Solution {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long sum = nums[n - 1];
        long ans = nums[0];
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] <= sum) sum += nums[i];
            else sum = nums[i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}