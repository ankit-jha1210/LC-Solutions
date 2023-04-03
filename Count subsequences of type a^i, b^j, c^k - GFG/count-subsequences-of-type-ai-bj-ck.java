//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int t = Integer.parseInt(sc.next());
		
		while(t>0)
		{
		    String s = sc.next();
		    
		    Solution T = new Solution();
		    System.out.println(T.fun(s));
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int mod = (int)Math.pow(10, 9) + 7;
    public int fun(String s)
    {
        int aCount = 0, bCount = 0, cCount = 0;
        
        for(char ch: s.toCharArray()) {
            
            if(ch == 'a') aCount = ((aCount * 2)%mod + 1) % mod;
            
            else if(ch == 'b') bCount = (aCount +( bCount * 2) % mod) % mod;
            
            else cCount = (bCount + (cCount * 2) % mod) % mod;
        }
        
        return cCount;
    }
}