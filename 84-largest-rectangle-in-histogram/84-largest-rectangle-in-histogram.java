class Solution {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int maxA = 0;
        for (int i = 0; i <= heights.length; i++) {
            while (!stk.isEmpty() && (i == heights.length || heights[stk.peek()] > heights[i])) {
                int width;
                int idx = stk.pop();
                if (stk.isEmpty()) width = i; 
                else width = i - stk.peek() - 1;
                maxA = Math.max(maxA, width * heights[idx]);
            }
            stk.push(i);
        }
        return maxA;
    }
}
