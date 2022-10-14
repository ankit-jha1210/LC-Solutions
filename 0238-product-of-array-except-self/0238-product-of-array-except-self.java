class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) left[i] = left[i - 1] * nums[i];
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) right[i] = right[i + 1] * nums[i];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = 1;
            if (i - 1 >= 0) res[i] = left[i - 1];
            if (i + 1 < n) res[i] *= right[i + 1];
        }
        return res;
    }
}
