class Solution {

    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int cnt = 0;
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (map.containsKey(key - k)) {
                cnt += value * map.get(key - k);
            } 
            if(map.containsKey(key + k)) {
                cnt += value * map.get(key + k);
            }
            map.put(key, 0);
        }
        return cnt;
    }
}
