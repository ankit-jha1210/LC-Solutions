class Solution {

    public int removeDuplicates(int[] nums) {
        int idx = 0, i = 0;
        while (i < nums.length) {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[i]) j++;
            nums[idx++] = nums[i];
            i = j;
        }
        return idx;
    }
}
