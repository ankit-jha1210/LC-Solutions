//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr) {
        if(arr[0] == 0) return -1;
        int jumps = 1, maxR = arr[0], steps = arr[0];
        int idx = 1;
        while(idx < arr.length - 1) {
            // if(idx == arr.length - 1) return jumps;
            maxR = Math.max(maxR, arr[idx] + idx);
            steps--;
            if(steps == 0) {
                jumps++;
                if(maxR <=  idx) return -1;
                
                steps = maxR - idx;
            }
            idx++;
        }
        return jumps;
    }
}