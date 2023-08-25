class Solution {

    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) stk.pop();
            if (stk.isEmpty()) pse[i] = 0; else pse[i] = stk.peek() + 1;
            stk.push(i);
        }
        while(!stk.isEmpty()) stk.pop();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) stk.pop();
            if (stk.isEmpty()) nse[i] = n - 1; else nse[i] = stk.peek() - 1;
            stk.push(i);
        }
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] + 1;
            maxi = Math.max(maxi, width * nums[i]);
        }
        return maxi;
    }
}
