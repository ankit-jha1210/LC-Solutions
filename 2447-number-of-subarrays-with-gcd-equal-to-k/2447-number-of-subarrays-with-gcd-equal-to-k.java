class Solution {

    public int subarrayGCD(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) res++;
            int tmp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                tmp = gcd(nums[j], tmp);
                if(tmp == k) res++;
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
