class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int i = 0, j = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        while (j < n) {
            while (!dq.isEmpty() && dq.peekLast() < nums[j]) dq.pollLast();
            dq.offer(nums[j]);
            if (j - i + 1 < k) j++; else {
                res[i] = dq.peek();
                if (nums[i] == dq.peekFirst()) dq.poll();
                i++;
                j++;
            }
        }
        return res;
    }
}
