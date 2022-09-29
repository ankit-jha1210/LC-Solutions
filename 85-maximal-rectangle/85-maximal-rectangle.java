class Solution {
    
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int maxi = 0;
        int[] dp = new int[n];
        for(int i = 0; i< m;i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') dp[j]++;
                else dp[j] = 0;
            }
            int res = largestRectangleArea(dp);
            maxi = Math.max(maxi, res);
        }
        return maxi;
    }
     public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        int max = 0;
        for(int i = 0;i<=n;i++){
            while(!stk.isEmpty() && (i == n || nums[stk.peek()] >= nums[i])){
                int height = nums[stk.pop()];
                int width;
                if(stk.isEmpty()) width = i;
                else width = i - stk.peek() - 1;
                max = Math.max(max, width*height);
            }
            stk.push(i);
        }
        return max;
    }
}