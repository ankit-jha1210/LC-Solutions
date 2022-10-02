class Solution {

    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 % 2 == 0 && n2 % 2 == 0) return 0;
        else if(n1 % 2 == 1 && n2 % 2 == 1) return xor(nums1) ^ xor(nums2);
        else if(n1 % 2 == 1) return xor(nums2);
        else return xor(nums1);
    }
    int xor(int[] nums) {
        int x = 0;
        for(int num: nums) x ^= num;
        return x;
    }
}
