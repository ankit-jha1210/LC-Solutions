class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        map.forEach(
            (key, value) -> {
                pq.add(new Pair(key, value));
                if (pq.size() > k) pq.poll();
            }
        );
        int[] arr = new int[k];
        int i = 0;
        while (!pq.isEmpty()) arr[i++] = pq.poll().first;
        return arr;
    }
}
