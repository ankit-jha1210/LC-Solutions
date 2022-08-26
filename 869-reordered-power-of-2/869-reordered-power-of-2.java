class Solution {

    public boolean reorderedPowerOf2(int n) {
        int[] nums = count(n);
        int power = 1;
        for (int i = 0; i < 30; i++) {
            if (Arrays.equals(nums, count(1 << i))) return true;
        }
        return false;
    }

    int[] count(int n) {
        int[] nums = new int[10];
        while (n > 0) {
            nums[n % 10]++;
            n /= 10;
        }
        return nums;
    }
}
