//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.math.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //taking number of elements
		    int n=sc.nextInt();
		   
		    //calling findCatalan() method
		    System.out.println(new Solution().findCatalan(n));
		}
	}
}
// } Driver Code Ends



class Solution
{
    //Function to find the nth catalan number.
    public static BigInteger findCatalan(int n)
    {
        BigInteger[] dp = new BigInteger[n + 1];
        
        return solve(n, dp);
    }
    
    static BigInteger solve(int n, BigInteger[] dp)  {
        
        if(n == 0 || n== 1) return BigInteger.valueOf(1);
        
        if(dp[n] != null) return dp[n];
        
        BigInteger sum = new BigInteger("0");
        for(int i = 0; i < n; i++) {
           sum =  sum.add(solve(i, dp).multiply(solve(n - i - 1, dp)));
        }
        
        return dp[n] = sum;
    }
}