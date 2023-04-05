//{ Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        Boolean[][] dp = new Boolean[N][sum + 1];
        return solve(N - 1, arr, sum, dp);
    }
    
    static Boolean solve(int ind, int[] arr, int sum, Boolean[][] dp) {
        if(sum == 0) return true;
        
        if(ind == 0) {
            if(arr[0] == sum) return true;
            return false;
        }
        if(dp[ind][sum] != null) return dp[ind][sum];
        Boolean take = false;
        if(arr[ind] <= sum) take = solve(ind - 1, arr, sum - arr[ind], dp);
        
        Boolean not = solve(ind - 1, arr, sum, dp);
        
        return dp[ind][sum] =  take || not;
    }
}