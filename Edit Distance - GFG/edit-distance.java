//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
        
        Integer[][] dp = new Integer[s.length()][t.length()];
        return solve(s, t, s.length() - 1, t.length() - 1, dp);
    }
    
    int solve(String s, String t, int i, int j, Integer[][] dp) {
        
        if(i < 0 && j < 0) return 0;
        if(i < 0) return  j + 1;
        if(j < 0) return i + 1;
        
        if(dp[i][j] != null) return dp[i][j];
        
        if(s.charAt(i) == t.charAt(j)) return solve(s, t, i - 1, j - 1, dp);
        
        int op1 = solve(s, t, i , j - 1, dp);
        int op2 = solve(s, t, i - 1, j, dp);
        int op3 = solve(s, t, i - 1, j - 1, dp);
        
        return dp[i][j] =  Math.min(op1, Math.min(op2, op3)) + 1;
    }
}