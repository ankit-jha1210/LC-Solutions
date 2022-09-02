class Solution {

    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) map.put(stones[i], new HashSet<>());
        map.get(0).add(1);
        for (int i = 0; i < stones.length; i++) {
            HashSet<Integer> options = map.get(stones[i]);
            for (int num : options) {
                int pos = stones[i] + num;
                if (pos == stones[stones.length - 1]) return true;
                if (map.containsKey(pos)) {
                    if (num - 1 > 0) map.get(pos).add(num - 1);
                    map.get(pos).add(num);
                    map.get(pos).add(num + 1);
                }
            }
        }
        return false;
    }
}
