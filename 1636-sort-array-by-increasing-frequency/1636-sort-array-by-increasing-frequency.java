class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.second == b.second ? b.first - a.first : a.second - b.second);
        map.forEach(
            (key, value) -> {
                pq.add(new Pair(key, value));
            }
        );
        int[] res = new int[nums.length];
        int i = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int num = p.first;
            for (int j = 0; j < p.second; j++) {
                res[i++] = num;
            }
        }
        return res;
    }
}
