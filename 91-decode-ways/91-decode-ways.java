class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }
    public int helper(String s, int ind, int[] dp){
        if(ind == s.length()) return 1;
        if(dp[ind] != -1) return dp[ind];
        int firstLetter = s.charAt(ind)-'0';
        int firstLetter_choice = 0;
         if(firstLetter > 0) firstLetter_choice = helper(s, ind+1, dp);
        int secondLetter_choice = 0;
        if(ind+1<s.length()){
            int secondLetter = firstLetter*10 + s.charAt(ind+1)-'0';
            if(secondLetter>=10 && secondLetter<=26) secondLetter_choice = helper(s,ind+2, dp);
        }
        return dp[ind] = firstLetter_choice + secondLetter_choice;
    }
}