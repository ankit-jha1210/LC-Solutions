class Solution {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftSmallest = new int[n];
        int[] rightSmallest = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && heights[i] <= heights[stk.peek()]) stk.pop();
            if (stk.isEmpty()) leftSmallest[i] = 0; 
            else leftSmallest[i] = stk.peek() + 1;
            stk.push(i);
        }
        while (!stk.isEmpty()) stk.pop();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && heights[i] <= heights[stk.peek()]) stk.pop();
            if (stk.isEmpty()) rightSmallest[i] = n - 1; 
            else rightSmallest[i] = stk.peek() - 1;
            stk.push(i);
        }
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int width = rightSmallest[i] - leftSmallest[i] + 1;
            maxi = Math.max(maxi, width * heights[i]);
        }
        return maxi;
    }
}
