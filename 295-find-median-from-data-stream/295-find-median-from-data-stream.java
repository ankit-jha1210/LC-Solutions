class MedianFinder {
    PriorityQueue<Integer> min, max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if ((min.size() == 0 && max.size() == 0) || num < max.peek()) max.add(num); else min.add(num);
        if (min.size() - max.size() == 2) {
            max.add(min.poll());
        } else if (max.size() - min.size() == 2) min.add(max.poll());
    }

    public double findMedian() {
        if ((min.size() + max.size()) % 2 == 0) {
            double res = (1.0 * min.peek() + max.peek())/2;
            return res;
        } 
        else return min.size() > max.size() ? min.peek() : max.peek();
    }
}
