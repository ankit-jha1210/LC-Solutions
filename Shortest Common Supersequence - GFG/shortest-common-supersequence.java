//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends
class Solution
{
    public static int shortestCommonSupersequence(String s,String t,int m,int n)
    {
        
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
            
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    
                }
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        int i = m, j = n;
        int size = 0;
        while(i > 0 && j > 0) {
            
            if(s.charAt(i - 1) == t.charAt(j - 1)) {
                i--;
                j--;
            }
            else if(dp[i - 1][j] > dp[i][j - 1]) i--;
            else j--;
            size++;
        }
        
        if(i > 0) size += i;
        else if(j > 0) size += j;
        
        return size;
        
        
    }
}