class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int idx = 0; idx < nums.length - 1; idx++) {
            int i = idx + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[idx] + nums[i] + nums[j];
                if (sum == 0) {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[idx]);
                    lst.add(nums[i]);
                    lst.add(nums[j]);
                    res.add(lst);
                    while(i+1<nums.length && nums[i+1] == nums[i]) i++;
                    while(j-1 >= 0 && nums[j] == nums[j-1]) j--;
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
