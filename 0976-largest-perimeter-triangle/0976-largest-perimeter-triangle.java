class Solution {

    public int largestPerimeter(int[] nums) {
        // s2 + s3 > s1
        Arrays.sort(nums);
        for (int i = nums.length - 3; i >=0; i--) {
            int s1 = nums[i + 2], s2 = nums[i + 1], s3 = nums[i];
            if (s1 < s2 + s3) return s1 + s2 + s3;
        }
        return 0;
    }
}
