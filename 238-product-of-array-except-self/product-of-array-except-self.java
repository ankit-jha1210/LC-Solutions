class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            prefix[i] = nums[i];
            if (i - 1 >= 0) prefix[i] *= prefix[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = nums[i];
            if (i + 1 < n) suffix[i] *= suffix[i + 1];
        }
        res[0] = suffix[1];
        res[n - 1] = prefix[n - 2];
        for (int i = 1; i < n - 1; i++) {
            res[i] = suffix[i + 1] * prefix[i - 1];
        }
        return res;
    }
}
