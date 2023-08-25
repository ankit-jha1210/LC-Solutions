class Solution {

    public int singleNonDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (i + 1 < nums.length && nums[i] != nums[i + 1]) return nums[i];
            i += 2;
        }
        return nums[nums.length - 1];
    }
}
