class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int low = 0, high = n1;
        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = (n1 + n2) / 2 - cut1;
            int l1 = cut1 - 1 >= 0 ? nums1[cut1 - 1] : Integer.MIN_VALUE;
            int r1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int l2 = cut2 - 1 >= 0 ? nums2[cut2 - 1] : Integer.MIN_VALUE;
            int r2 = cut2 == n2 ? Integer.MAX_VALUE: nums2[cut2];
            if(l1 <= r2 && l2 <= r1) {
                if((n1+n2) % 2 == 0) return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else return Math.min(r1, r2);
            }
            else if(l1 > r2) high = cut1 - 1;
            else low = cut1 + 1;
        }
        return -1;
    }
}
