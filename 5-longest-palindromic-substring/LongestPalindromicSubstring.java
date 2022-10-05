class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        
        int n = s.length() ;
        int dp[][] = new int[n+1][n+1] ;
        String ans = "" ;
        for(int g = 1 ; g <=n ; g++){
            for(int i = 1 , j = g ; i<= n-g+1 ;j++ , i++){
                
                if(i==j){
                    dp[i][j] = 1 ;
                }
                else if(j -i == 1){
                    if(s.charAt(i-1) == s.charAt(j-1)){
                        dp[i][j] = 1 ;
                    }
                }
                else{
                    if(s.charAt(i-1) == s.charAt(j-1) && dp[i+1][j-1] == 1){
                        dp[i][j] = 1 ;
                    }
                }
                if(dp[i][j] ==1){
                    ans = s.substring(i-1,j);
                }
            }
        }
        return ans ;
    }
}