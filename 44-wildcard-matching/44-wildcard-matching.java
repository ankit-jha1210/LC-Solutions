class Solution {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        Boolean[][] dp = new Boolean[m + 1][n + 1];
        return solve(s, p, m, n, dp);
    }

    boolean solve(String s, String p, int i, int j, Boolean[][] dp) {
        if (i == 0 && j == 0) return true;
        if (j == 0) return false;
        if (i == 0) {
            for (int ind = 0; ind < j; ind++) {
                if (p.charAt(ind) != '*') return false;
            }
            return true;
        }
        if (dp[i][j] != null) return dp[i][j];
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
            return dp[i][j] = solve(s, p, i - 1, j - 1, dp);
        } else if (p.charAt(j - 1) == '*') {
            return dp[i][j] = solve(s, p, i - 1, j, dp) || solve(s, p, i, j - 1, dp);
        }
        return dp[i][j] = false;
    }
}
