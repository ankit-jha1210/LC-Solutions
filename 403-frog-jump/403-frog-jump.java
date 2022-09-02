class Solution {

    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int stone : stones) map.put(stone, new HashSet<>());
        map.get(0).add(1);
        for (int stone : stones) {
            HashSet<Integer> jumps = map.get(stone);
            for (int jump : jumps) {
                if (jump + stone == stones[stones.length - 1]) return true;
                if (map.containsKey(jump + stone)) {
                    if (jump - 1 > 0) map.get(jump + stone).add(jump - 1);
                    map.get(jump + stone).add(jump);
                    map.get(jump + stone).add(jump + 1);
                }
            }
        }
        return false;
    }
}
