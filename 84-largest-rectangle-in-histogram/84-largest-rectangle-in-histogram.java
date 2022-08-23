class Solution {
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