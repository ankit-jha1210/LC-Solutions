class MinStack {
    Stack<Long> stk;
    Long min;

    public MinStack() {
        stk = new Stack<>();
        min = Long.MAX_VALUE;
    }

    public void push(int value) {
        Long val = Long.valueOf(value);
        if (stk.isEmpty()) {
            stk.push(val);
            min = val;
        } else {
            if (val < min) {
                stk.push(2 * val - min);
                min = val;
            } else stk.push(val);
        }
    }

    public void pop() {
        Long val = stk.pop();
        if (val < min) {
            min = 2 * min - val;
        }
    }

    public int top() {
        Long val = stk.peek();
        if(val < min) return min.intValue();
        else return val.intValue();
    }

    public int getMin() {
        return min.intValue();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
