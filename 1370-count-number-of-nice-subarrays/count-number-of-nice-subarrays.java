class Solution {

    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0, res = 0;
        map.put(0, 1);
        for (int num : nums) {
            if (num % 2 == 1) cnt++;

            if (map.containsKey(cnt - k)) res += map.get(cnt - k);
            map.put(cnt, map.getOrDefault(cnt, 0) + 1);
        }
        return res;
    }
}
