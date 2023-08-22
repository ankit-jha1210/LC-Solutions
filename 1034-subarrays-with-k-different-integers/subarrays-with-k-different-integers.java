class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k - 1);
    }

    int solve(int[] nums, int k) {
        // finding cnt <= k subarrays
        int i = 0, j = 0;
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() > k) {
                int freq = map.get(nums[i]) - 1;
                if (freq == 0) map.remove(nums[i]); else map.put(nums[i], freq);
                i++;
            }
            len += j - i + 1;
            j++;
        }
        return len;
    }
}
