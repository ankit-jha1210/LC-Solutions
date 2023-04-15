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
            

            Solution ob = new Solution();
            if(ob.is1winner(N,arr))
            System.out.println("1");
            else
            System.out.println("0");
            
        }
    }
}

// } Driver Code Ends


class Solution{

    static Boolean is1winner(int N, int nums[]){
        Integer[][] dp = new Integer[N][N];
        return winner(nums, 0, N - 1, dp) > 0;
    }
     static int winner(int[] nums, int s, int e, Integer[][] dp) {

        if(s == e) return nums[s];

        if(dp[s][e] != null) return dp[s][e];

        int a = nums[s] - winner(nums, s + 1, e, dp);
        int b = nums[e] - winner(nums, s, e - 1, dp);

        return dp[s][e] =  Math.max(a, b);

    }
}