class Solution {

    public int majorityElement(int[] nums) {
        int cnt = 0;
        int element = 0;
        for (int num : nums) {
            if (cnt == 0) {
                element = num;
                cnt = 1;
            } else if (num == element) cnt++; else cnt--;
        }
        return element;
    }
}
