class Solution {

    public long maximumSubarraySum(int[] nums, int k) {
        int i = 0, j = 0;
        long sum = 0, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            sum += nums[j];
            if (j - i + 1 < k) j++; else {
                if (map.size() == j - i + 1) {
                    ans = Math.max(ans, sum);
                }
                sum -= nums[i];

                int freq = map.get(nums[i]) - 1;
                if (freq == 0) map.remove(nums[i]); 
                else map.put(nums[i], freq);
                i++;
                j++;
            }
        }
        return ans;
    }
}
