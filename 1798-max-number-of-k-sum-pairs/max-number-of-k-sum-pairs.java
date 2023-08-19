class Solution {

    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int num : nums) {
            if (map.containsKey(k - num)) {
                int freq = map.get(k - num) - 1;
                if (freq == 0) map.remove(k - num); 
                else map.put(k - num, freq);
                cnt++;
            } else map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return cnt;
    }
}
