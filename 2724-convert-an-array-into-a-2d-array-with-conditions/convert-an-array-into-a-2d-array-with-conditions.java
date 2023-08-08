class Solution {

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int rows = 1;
        for (int num : nums) {
            if (map.containsKey(num)) {
                int freq = map.get(num) + 1;
                map.put(num, freq);
                rows = Math.max(rows, freq);
            } else map.put(num, 1);
        }
        for (int row = 0; row < rows; row++) {
            List<Integer> temp = new ArrayList<>();
            for (int key : map.keySet()) {
                if (map.get(key) == 0) continue;
                int occurence = map.get(key) - 1;
                map.put(key, occurence);
                temp.add(key);
            }
            res.add(temp);
        }
        return res;
    }
}
