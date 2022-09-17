class Solution {

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int left = findSum(nums, 0, i - 1);
            int right = findSum(nums, i + 1, n - 1);
            if (left == right) return i;
        }
        return -1;
    }

    int findSum(int[] nums, int s, int e) {
        int sum = 0;
        while (s <= e) sum += nums[s++];
        return sum;
    }
}
