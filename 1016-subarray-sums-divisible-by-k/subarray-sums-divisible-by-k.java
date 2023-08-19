class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cnt = 0, sum = 0;
        for(int num: nums) {
            sum += num;
            int rem = sum % k;
            if(rem < 0) {
                rem += k;
            }
            if(map.containsKey(rem)) {
                cnt += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            }
            else map.put(rem, 1);
        }
        return cnt;
    }
}