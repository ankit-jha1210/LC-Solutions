class Pair {
    int val, min;

    Pair(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

class MinStack {
    Stack<Pair> stk;

    public MinStack() {
        stk = new Stack<>();
    }

    public void push(int val) {
        if (stk.isEmpty()) {
            stk.push(new Pair(val, val));
        }
        else{
            int min = Math.min(val,stk.peek().min);
            stk.push(new Pair(val, min));
        }
    }

    public void pop() {
        stk.pop();
    }

    public int top() {
        return stk.peek().val;
    }

    public int getMin() {
        return stk.peek().min;
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
