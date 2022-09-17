class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int idx = 0; idx < nums.length - 1; idx++) {
            int i = idx + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[idx] + nums[i] + nums[j];
                if (sum == 0) {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[idx]);
                    lst.add(nums[i]);
                    lst.add(nums[j]);
                    if (!set.contains(lst)) {
                        set.add(lst);
                        res.add(lst);
                    }
                    i++;
                    j--;
                } else if (sum > 0) j--; 
                else i++;
            }
            while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) idx++;
        }
        return res;
    }
}
