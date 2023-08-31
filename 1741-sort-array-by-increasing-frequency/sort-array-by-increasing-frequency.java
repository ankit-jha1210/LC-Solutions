class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if(map.get(a) - map.get(b) == 0) return b - a;
            return map.get(a) - map.get(b);
        });

        for(int key: map.keySet()) pq.add(key);

        int idx = 0;
        int[] res = new int[nums.length];
        while(!pq.isEmpty()) {
            int key = pq.poll();
            int freq = map.get(key);
            for(int j = 0; j < freq; j++) res[idx++] = key;
        }
        return res;
    }
}