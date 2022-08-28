class Solution {

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : map.keySet()) {
            pq.add(num);
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            int num = pq.poll();
            int occurences = map.get(num);
            if (occurences == 0) continue;
            for (int j = 0; j < k; j++) {
                if (!map.containsKey(num + j) || map.get(num + j) < occurences) {
                    return false;
                } else {
                    map.put(num + j, map.get(num + j) - occurences);
                    ans += occurences;
                }
            }
        }
        return ans == nums.length;
    }
}
