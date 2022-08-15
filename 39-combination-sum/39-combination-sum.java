class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        helper(nums, target, 0, new ArrayList<>());
        return res;
    }

    void helper(int[] nums, int target, int ind, List<Integer> temp) {
        if (ind == nums.length) {
            if (target == 0) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        if (nums[ind] <= target) {
            temp.add(nums[ind]);
            helper(nums, target - nums[ind], ind, temp);
            temp.remove(temp.size() - 1);
        }
        helper(nums, target, ind + 1, temp);
    }
}
