class MyQueue {
    Stack<Integer> stk, helper;
    public MyQueue() {
        stk = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int x) {
        while(!stk.isEmpty()) helper.push(stk.pop());
        stk.push(x);
        while(!helper.isEmpty()) stk.push(helper.pop());
    }
    
    public int pop() {
        return stk.pop();
    }
    
    public int peek() {
        return stk.peek();
    }
    
    public boolean empty() {
        return stk.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */