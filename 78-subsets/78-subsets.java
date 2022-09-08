class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        int masks = 1 << nums.length;
        for (int i = 0; i < masks; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) tmp.add(nums[j]);
            }
            lst.add(tmp);
        }
        return lst;
    }
}
