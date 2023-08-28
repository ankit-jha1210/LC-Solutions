class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            prefix[i] = nums[i];
            if (i - 1 >= 0) prefix[i] *= prefix[i - 1];
        }
        int pro = nums[n - 1];
        res[n - 1] = prefix[n - 2];
        for (int i = n - 2; i > 0; i--) {
            res[i] = prefix[i - 1] * pro;
            pro *= nums[i];
        }
        res[0] = pro;
        return res;
    }
}
