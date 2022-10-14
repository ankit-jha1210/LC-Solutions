class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums;
        int[] res = new int[n];
        res[0] = nums[0];
        for (int i = 1; i < n; i++) res[i] = res[i - 1] * nums[i];
        int pro = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = i - 1 >= 0 ? res[i - 1] : 1;
            res[i] *= pro;
            pro *= nums[i];
        }
        return res;
    }
}
