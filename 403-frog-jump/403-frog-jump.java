class Solution {

    public boolean canCross(int[] stones) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) map.put(stones[i], i);
        Boolean[][] dp = new Boolean[stones.length][stones.length];
        return solve(stones, 0, 1, map, dp);
    }

    boolean solve(int[] stones, int idx, int k, Map<Integer, Integer> map, Boolean[][] dp) {
        if (idx == stones.length - 1) return true;
        if (dp[idx][k] != null) return dp[idx][k];
        if (stones[idx] + k - 1 > stones[idx]) {
            if (map.containsKey(stones[idx] + k - 1) && solve(stones, map.get(stones[idx] + k - 1), k - 1, map, dp)) return dp[idx][k - 1] = true;
        }

        if (map.containsKey(stones[idx] + k)) {
            if (solve(stones, map.get(stones[idx] + k), k, map, dp)) return dp[idx][k] = true;
        }
        if (idx != 0 && map.containsKey(stones[idx] + k + 1)) {
            if (solve(stones, map.get(stones[idx] + k + 1), k + 1, map, dp)) return dp[idx][k + 1] = true;
        }
        return dp[idx][k] = false;
    }
}
// jump omly if that unit is present and map all the values
// and take prev
