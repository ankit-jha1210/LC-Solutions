//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxi = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum == 0) maxi = i + 1;
            else if(map.containsKey(sum)) {
                maxi = Math.max(maxi, i - map.get(sum));
            }
            else map.put(sum, i);
            
        }
        
        return maxi;
    }
}