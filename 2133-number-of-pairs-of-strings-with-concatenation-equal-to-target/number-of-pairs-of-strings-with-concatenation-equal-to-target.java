class Solution {

    public int numOfPairs(String[] nums, String target) {
        HashMap<String, Integer> map = new HashMap<>();
        int cnt = 0;
        for (String num : nums) {
            if (target.startsWith(num)) {
                String sub = target.substring(num.length());
                if (map.containsKey(sub)) {
                    cnt += map.get(sub);
                }
            }
            if (target.endsWith(num)) {
                String sub = target.substring(0, target.length() - num.length());
                if (map.containsKey(sub)) {
                    cnt += map.get(sub);
                }
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return cnt;
    }
}
