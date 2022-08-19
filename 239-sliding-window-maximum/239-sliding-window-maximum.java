class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int idx = 0;
        for(int i = 0;i<n;i++){
            // if front element is out of bound
            if(!deque.isEmpty() && deque.peek() == i-k) deque.poll();
            // eliminate all the elements lesser than the current
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) deque.pollLast();
            deque.offer(i);
            if(i>=k-1) res[idx++] = nums[deque.peek()];
        }
        return res;
    }
}
