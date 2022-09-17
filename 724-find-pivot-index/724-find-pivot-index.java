class Solution {

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) prefix[i] = nums[i] + prefix[i - 1];
        for (int i = 0; i < n; i++) {
            int left = i - 1 >= 0 ? prefix[i - 1] : 0;
            int right = prefix[n - 1] - prefix[i];
            if (left == right) return i;
        }
        return -1;
    }
}
