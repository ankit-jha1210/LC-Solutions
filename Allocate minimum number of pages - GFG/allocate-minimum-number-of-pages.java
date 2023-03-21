//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        if(M > N) return -1;
        int low = Integer.MAX_VALUE, high = 0;
        
        for(int num: A) {
            low = Math.min(low, num);
            high += num;
        }
        
        int ans = -1;
        while(low <= high) {
            
            int mid = low + (high - low)/2;
            
            if(isPossible(A, mid, M)) {
                high = mid - 1;
                ans = mid;
            }
            else low = mid + 1;
        }
        
        return ans;
    }
    
    static boolean isPossible(int[] A, int max, int students) {
        int curr = 1, sum = 0;
        for(int num: A) {
            if(num > max) return false;
            sum += num;
            if(sum > max) {
                curr++;
                if(curr > students) return false;
                sum = num;
            }
        }
        return true;
    }
    
};