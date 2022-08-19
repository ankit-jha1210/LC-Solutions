class Solution {

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '#') {
                if (!stk1.isEmpty()) stk1.pop();
            } else stk1.push(ch);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (ch == '#') {
                if (!stk2.isEmpty()) stk2.pop();
            } else stk2.push(ch);
        }
        if (stk1.size() != stk2.size()) return false;
        while (!stk1.isEmpty()) {
            if (stk1.pop() != stk2.pop()) return false;
        }
        return true;
    }
}
