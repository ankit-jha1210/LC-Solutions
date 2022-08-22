class Solution {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int size = 2 * n;
        int[] nge = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = size - 1; i >= 0; i--) {
            int idx = i % n;
            while (!stk.isEmpty() && stk.peek() <= nums[idx]) stk.pop();
            if (stk.isEmpty()) nge[idx] = -1; 
            else nge[idx] = stk.peek();
            stk.push(nums[idx]);
        }
        return nge;
    }
}
