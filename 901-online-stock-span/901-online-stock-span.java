class Pair {
    int idx;
    int price;

    Pair(int idx, int price) {
        this.idx = idx;
        this.price = price;
    }
}

class StockSpanner {
    Stack<Pair> stk;
    int pos;

    public StockSpanner() {
        stk = new Stack<>();
    }

    public int next(int price) {
        while (!stk.isEmpty() && stk.peek().price <= price) stk.pop();
        int ans;
        if (stk.isEmpty()) ans = pos + 1; else ans = pos - stk.peek().idx;
        stk.push(new Pair(pos, price));
        pos++;
        return ans;
    }
}
