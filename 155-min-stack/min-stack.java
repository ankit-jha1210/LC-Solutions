class MinStack {
    Stack<Long> stk;
    Long min;

    public MinStack() {
        stk = new Stack<>();
        min = Long.MAX_VALUE;
    }

    public void push(int val) {
        Long value = Long.valueOf(val);
        if (stk.isEmpty()) {
            stk.push(value);
            min = value;
        } else {
            if (value < min) {
                stk.push(2 * value - min);
                min = value;
            } else {
                stk.push(value);
            }
        }
    }

    public void pop() {
        Long num = stk.pop();
        if (min > num) min = 2 * min - num;
    }

    public int top() {
        Long num = stk.peek();
        if (num < min) return min.intValue(); 
        else return num.intValue();
    }

    public int getMin() {
        return min.intValue();
    }
}
