class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer> buckets[] = new ArrayList[nums.length + 1];
        map.forEach(
            (key, value) -> {
                if (buckets[value] == null) {
                    buckets[value] = new ArrayList<>();
                }
                buckets[value].add(key);
            }
        );
        int[] res = new int[k];
        int freq = nums.length, idx = 0;
        while (freq > 0) {
            List<Integer> freqList = buckets[freq];
            if (freqList != null) {
                for (int num : freqList) {
                    res[idx++] = num;
                    if (idx == k) return res;
                }
            }
            freq--;
        }
        return res;
    }
}
