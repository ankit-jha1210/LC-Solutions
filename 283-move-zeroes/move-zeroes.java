class Solution {

    public void moveZeroes(int[] nums) {
        int pos = 0, i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
                pos++;
            }
            i++;
        }
    }
}
