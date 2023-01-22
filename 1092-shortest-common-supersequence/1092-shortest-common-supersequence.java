class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        return lcs(str1, str2);
    }

    public String lcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int i = n, j = m;
        String str = "";
        while(i > 0 && j > 0) {
            if(s.charAt(i - 1) == t.charAt(j - 1)) {
                str = s.charAt(i - 1) + str;
                i--;
                j--;
            }
            else if(dp[i - 1][j] > dp[i][j - 1]) {
                str = s.charAt(i - 1) + str;
                i--;
            }
            else {
                str = t.charAt(j - 1) + str;
                j--;
            }
        }
        while(i > 0) {
            str = s.charAt(i - 1) + str;
            i--;
        }
        while(j > 0) {
            str = t.charAt(j - 1) + str;
            j--;
        }
        return str;
    }
}
