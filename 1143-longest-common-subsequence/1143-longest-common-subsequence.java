class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length()][text2.length()];
        return solve(text1, text2, text1.length() - 1, text2.length() - 1, dp);
    }

    int solve(String s, String t, int i, int j, Integer[][] dp) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != null) return dp[i][j];
        if (s.charAt(i) == t.charAt(j)) return 1 + solve(s, t, i - 1, j - 1, dp);
        return dp[i][j] = Math.max(solve(s, t, i - 1, j, dp), solve(s, t, i, j - 1, dp));
    }
}
