class KthLargest {
int size;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.size = k;
        for(int num: nums) {
            pq.add(num);
            if(pq.size() > size) pq.poll();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > size) pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */