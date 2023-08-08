class Solution {

    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int num: nums) {
            int req = k - num;
            if(map.containsKey(req)) {
                ans++;
                int freq = map.get(req);
                if(freq == 1) map.remove(req);
                else map.put(req, freq - 1);
            }
            else map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return ans;
    }
}
