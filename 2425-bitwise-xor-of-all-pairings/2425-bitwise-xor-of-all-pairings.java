class Solution {

    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 % 2 == 0 && n2 % 2 == 0) return 0;
        int xor1 = xor(nums1);
        int xor2 = xor(nums2);
        return (n1 % 2 == 1 && n2 % 2 == 1) ? xor1 ^ xor2 : (n1 % 2 == 1) ? xor2 : xor1;
    }
    int xor(int[] nums) {
        int x = 0;
        for(int num: nums) x ^= num;
        return x;
    }
}
