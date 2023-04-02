//{ Driver Code Starts
//initial code
import java.util.*;
import java.lang.*;
class InterLeaveString
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            String a =sc.next();
            String b = sc.next();
            String c = sc.next();
            Solution g=new Solution();
        
            System.out.println(g.isInterLeave(a,b,c)==true?1:0);
            t--;
        }
    }
}


// } Driver Code Ends


/*you are required to complete this method */
class Solution {
	public boolean isInterLeave(String a,String b,String c)
	{
	    int m = a.length(), n = b.length();
	    Boolean[][] dp = new Boolean[m + 1][n + 1];
	    if((m + n) != c.length()) return false;
            return solve(a, b, c, 0, 0, dp);
	}
	
	boolean solve(String a, String b, String c, int i, int j, Boolean[][] dp) {
	    if(i == a.length() && j == b.length()) return true;
	    
	    if(dp[i][j] != null) return dp[i][j];
	    if(i < a.length() && j < b.length()) {
	    if(a.charAt(i) == b.charAt(j) && b.charAt(j) == c.charAt(i + j)) {
	        return dp[i][j] =  solve(a, b, c, i + 1, j, dp) || solve(a, b, c, i, j + 1, dp);
	    }
	    }
	    if(i < a.length() && a.charAt(i) == c.charAt(i + j)) return dp[i][j] = solve(a, b, c, i + 1, j, dp);
	    else if(j < b.length() && b.charAt(j) == c.charAt(i + j)) return dp[i][j] =  solve(a, b, c, i, j + 1, dp);
	    else return dp[i][j] =  false;
	}
}

