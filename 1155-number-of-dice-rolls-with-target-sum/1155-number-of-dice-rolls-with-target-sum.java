class Solution {
    final int mod = (int)(Math.pow(10, 9)) + 7;
    public int numRollsToTarget(int n, int k, int target) {
        Integer[][][] dp = new Integer[n + 1][k + 1][target + 1];
        return solve(n, k, k, target, dp);
    }
    int solve(int n, int k, int no_left, int target, Integer[][][] dp) {
        if(target == 0 && n == 0) return 1;
        if(n == 0 || target == 0 || no_left == 0) return 0;
        if(dp[n][no_left][target] != null) return dp[n][no_left][target];
         int pick = 0;
        if(target >= no_left) {
            pick = solve(n - 1, k, k, target - no_left, dp);
        }
        int notPick = solve(n, k,  no_left - 1, target, dp);
        return dp[n][no_left][target] =  (pick + notPick) % mod;
    }
}