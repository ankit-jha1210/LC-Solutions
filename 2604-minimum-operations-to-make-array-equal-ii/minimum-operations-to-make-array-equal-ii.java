class Solution {

    public long minOperations(int[] nums1, int[] nums2, int k) {
        long up = 0, down = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[i]) continue;
            int diff = Math.abs(nums1[i] - nums2[i]);
            if (k == 0 || diff % k != 0) return -1;
            diff /= k;
            if (nums1[i] > nums2[i]) down += diff; else up += diff;
        }
        return up == down ? up : -1;
    }
}
