class Solution {

    public int[] dailyTemperatures(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[stk.peek()] <= nums[i]) stk.pop();
            if (stk.isEmpty()) res[i] = 0; 
            else res[i] = stk.peek() - i;
            stk.push(i);
        }
        return res;
    }
}
