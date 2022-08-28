class Solution {

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int occurences = map.get(nums[i]);
            if (occurences == 0) continue;
            for (int j = 0; j < k; j++) {
                if (!map.containsKey(nums[i] + j) || map.get(nums[i] + j) < occurences) {
                    return false;
                } else {
                    map.put(nums[i] + j, map.get(nums[i] + j) - occurences);
                    ans += occurences;
                }
            }
        }
        return ans == nums.length;
    }
}
