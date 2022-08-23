class Solution {

    public boolean checkValidString(String s) {
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        return solve(s, 0, 0, dp);
    }

    boolean solve(String s, int open, int i, Boolean[][] dp) {
        if(open <0) return false;
        if (i == s.length()) return open == 0;
        if(dp[i][open] != null) return dp[i][open];
        char ch = s.charAt(i);
        if (ch == '(') return dp[i][open] = solve(s, open + 1, i + 1, dp); 
        else if (ch == ')') return dp[i][open] = solve(s, open - 1, i + 1, dp);
        else{
            return dp[i][open] = solve(s, open, i+1, dp) || solve(s, open+1, i+1, dp) || solve(s, open-1, i+1, dp);
        }
    }
}
