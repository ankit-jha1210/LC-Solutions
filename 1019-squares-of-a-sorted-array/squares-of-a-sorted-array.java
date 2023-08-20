class Solution {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
         int idx = 0;
        int neg = -1, pos = -1;
        if(nums[n - 1] < 0) {
            neg = n - 1;
             while (neg >= 0) res[idx++] = nums[neg] * nums[neg--];
             return res;
        }
        else if(nums[0] >= 0) {
            pos = 0;
            while (pos < n) res[idx++] = nums[pos] * nums[pos++];
            return res;
        }
        for (int i = 1; i < nums.length; i++) {
            if(nums[i - 1] < 0 && nums[i] >= 0) {
                neg = i - 1;
                pos = i;
            }
        }

       

        while (neg >= 0 && pos < n) {
            if (-nums[neg] < nums[pos]) {
                res[idx++] = nums[neg] * nums[neg--];
            } else {
                res[idx++] = nums[pos] * nums[pos++];
            }
        }

        while (pos < n) res[idx++] = nums[pos] * nums[pos++];
        while (neg >= 0) res[idx++] = nums[neg] * nums[neg--];

        return res;
    }
}
