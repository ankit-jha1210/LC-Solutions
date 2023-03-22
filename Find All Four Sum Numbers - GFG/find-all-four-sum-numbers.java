//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                int low = j + 1, high = arr.length - 1;
                while(low < high) {
                    int sum = arr[i] + arr[j] + arr[low] + arr[high];
                   if(sum == k) {
                       ArrayList<Integer> temp = new ArrayList<>();
                       temp.add(arr[i]);
                       temp.add(arr[j]);
                       temp.add(arr[low]);
                       temp.add(arr[high]);
                       ans.add(temp);
                       while(low < high && temp.get(2) == arr[low]) low++;
                       while(low < high && temp.get(3) == arr[high]) high--;
                   }
                   else if(sum < k) low++;
                   else high--;
                    
                }
                 while(j + 1 < arr.length && arr[j] == arr[j + 1]) j++;
            }
            while(i + 1 < arr.length && arr[i] == arr[i + 1]) i++;
        }
        return ans;
    }
}