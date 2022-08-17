class Solution {
    List<String> lst;

    public List<String> generateParenthesis(int n) {
        lst = new ArrayList<>();
        helper(n * 2, "");
        return lst;
    }

    public void helper(int size, String sb) {
        if (sb.length() == size) {
            if (isValid(sb)) lst.add(new String(sb));
            return;
        }
        if (sb.length() > size) return;
        helper(size, sb + "(");
        helper(size, sb + ")");
    }

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') stk.push(ch); else if (ch == ')') {
                if (!stk.isEmpty() && stk.peek() == '(') stk.pop(); else return false;
            }
        }
        return stk.isEmpty();
    }
}
