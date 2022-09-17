class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int sum = Integer.MAX_VALUE, n = nums.length;
        Arrays.sort(nums);
        for (int idx = 0; idx < n - 2; idx++) {
            int i = idx + 1, j = n - 1;
            while (i < j) {
                int tmp = nums[i] + nums[j] + nums[idx];
                if (Math.abs(target - tmp) < Math.abs(target - sum)) sum = tmp;
                if (tmp == target) return target; 
                else if (tmp < target) i++; 
                else j--;
            }
        }
        return sum;
    }
}
