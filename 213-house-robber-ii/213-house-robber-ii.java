class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) lst1.add(nums[i]);
            if (i != n - 1) lst2.add(nums[i]);
        }
        return Math.max(solve(lst1), solve(lst2));
    }

    int solve(List<Integer> nums) {
        int prev1 = nums.get(nums.size() - 1), prev2 = 0;
        for (int i = nums.size() - 2; i >= 0; i--) {
            int curr_i = Math.max(prev2 + nums.get(i), prev1);
            prev2 = prev1;
            prev1 = curr_i;
        }
        return prev1;
    }
}
