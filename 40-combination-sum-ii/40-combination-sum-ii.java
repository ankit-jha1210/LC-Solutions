class Solution {
List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        helper(nums, target, 0, new ArrayList<>());
        return res;
    }

    void helper(int[] nums, int target, int ind, List<Integer> temp) {
        if (ind == nums.length) {
            if (target == 0) res.add(new ArrayList<>(temp));
            return;
        }

        if (nums[ind] <= target) {
            temp.add(nums[ind]);
            helper(nums, target - nums[ind],ind+1, temp);
            temp.remove(temp.size() - 1);
        }
        int i;
        for (i = ind + 1; i < nums.length; i++) {
            if (nums[ind] != nums[i]) break;
        }
        helper(nums, target, i, temp);
    }
}
