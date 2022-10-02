class Solution {
    final int mod = (int) Math.pow(10, 9) + 7;

    public int numRollsToTarget(int n, int k, int target) {
        int[] prev = new int[target + 1];
        prev[0] = 1;
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[target + 1];
            for (int j = 1; j <= target; j++) {
                int ans = 0;
                for (int idx = 1; idx <= k; idx++) {
                    if (idx > j) break;
                    ans = (ans + prev[j - idx]) % mod;
                }
                curr[j] = ans;
            }
            prev = curr;
        }
        return prev[target];
    }
}
