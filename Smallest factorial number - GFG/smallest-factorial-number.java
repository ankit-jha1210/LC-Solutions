//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            System.out.println(new Solution().findNum(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findNum(int n)
    {
        int low = 0, high = 5 * n;
        
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(isPossible(mid, n)) {
                high = mid - 1;
                ans = mid;
            }
            else low = mid + 1;
        }
        return ans;
    }
    
    boolean isPossible(int num, int n) {
        int total = 0;
        for(int i = 5; i <= num; i *= 5) {
            total += (num / i);
        }
        return total >= n;
    }
}