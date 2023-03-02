//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine().trim());
			int [][] colors = new int[N][3];
			for(int i = 0; i < N; i++) {
				String [] str = br.readLine().trim().split(" ");
				colors[i][0] = Integer.parseInt(str[0]);
				colors[i][1] = Integer.parseInt(str[1]);
				colors[i][2] = Integer.parseInt(str[2]);
			}
			Solution obj = new Solution();
			out.println(obj.minCost(colors, N));
		}
		out.close();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    final int mod = (int)(Math.pow(10, 8));
	int minCost(int [][] colors, int N){
	    int k = colors[0].length;
	    Integer[][] dp = new Integer[N][k + 1];
        return solve(colors, N - 1, 3, dp);
    }
    int solve(int[][] colors, int row, int prevColor, Integer[][] dp) {
        if(row == 0) {
            int min = mod;
            for(int i = 0; i < colors[0].length; i++) {
                if(i != prevColor) {
                    min = Math.min(min, colors[0][i]);
                }
            }
            return min;
        }
        if(dp[row][prevColor] != null) return dp[row][prevColor];
        int min = mod;
        
        for(int i = 0; i < colors[0].length;i++) {
            if(prevColor != i) {
                int cost = solve(colors, row - 1, i, dp) + colors[row][i];
                min = Math.min(min, cost);
            }
        }
        return dp[row][prevColor] = min;
    }
}