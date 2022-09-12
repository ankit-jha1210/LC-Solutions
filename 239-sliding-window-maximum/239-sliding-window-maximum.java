class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int i = 0, j = 0;
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        while (j < nums.length) {
            while (!dq.isEmpty() && nums[j] > dq.peekLast()) dq.pollLast();
            dq.addLast(nums[j]);
            if (j - i + 1 < k) j++; 
            else {
                res[idx++] = dq.peek();
                if(dq.peek() == nums[i]) dq.poll();
                i++;
                j++;
            }
        }
        return res;
    }
}
