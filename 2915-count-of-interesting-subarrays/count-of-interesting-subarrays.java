class Solution {

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long ans = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            if (num % modulo == k) sum++;
            int mod_val = sum % modulo;
            int find = mod_val - k;
            if (find < 0) find += modulo;
            ans += map.getOrDefault(find, 0);
            map.put(mod_val, map.getOrDefault(mod_val, 0) + 1);
        }
        return ans;
    }
}
