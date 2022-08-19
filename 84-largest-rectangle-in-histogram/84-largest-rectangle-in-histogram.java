class Solution {
    public int largestRectangleArea(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int n = nums.length;
        int maxi = 0;
        for(int i = 0;i<=n;i++){
            while(!stk.isEmpty() && (i==n || nums[stk.peek()] >= nums[i])){
                int height = nums[stk.pop()];
                int width;
                if(stk.isEmpty()) width = i;
                else width = i - stk.peek() - 1;
                maxi = Math.max(maxi, height*width);
            }
            stk.push(i);
        }
        return maxi;
    }
}