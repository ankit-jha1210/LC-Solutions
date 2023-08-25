class Solution {
    public int largestRectangleArea(int[] a) {
        Stack<Integer> stk = new Stack<>();
        int n = a.length;
        int ans = 0;
        // we are making nse and i pointer is finding pse of the top element in the stack
        for(int i = 0;  i <= n; i++) {
            while(!stk.isEmpty() && (i == n || a[stk.peek()] > a[i])) {
                int height = a[stk.pop()];
                int width = 0;
                if(stk.isEmpty()) width = i;
                else width = i - stk.peek() - 1;
                ans = Math.max(ans, width * height);
            }
            stk.push(i);
        }
        return ans;
    }
}