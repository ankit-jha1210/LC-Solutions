//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
    static long minTime(int[] arr,int n,int k){
        long low = Integer.MIN_VALUE, high = 0;
        for(int num: arr) {
            low = Math.max(low, num);
            high += num;
        }
        
        long ans = -1;
        while(low <= high) {
            
            long mid = low + (high - low)/2;
            
            if(isPossible(arr, k, mid)) {
                high = mid - 1;
                ans = mid;
            }
            else low = mid + 1;
        }
        return ans;
    }
    
   static boolean isPossible(int[] arr, int k, long max) {
        long curr = 1, sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            if(sum > max) {
                curr++;
                if(curr > k) return false;
                
                sum = arr[i];
            }
        }
        return true;
    }
}


