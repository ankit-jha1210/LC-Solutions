class Solution {
    List<String> lst;

    public List<String> generateParenthesis(int n) {
        lst = new ArrayList<>();
        helper("", n, n);
        return lst;
    }

    public void helper(String str, int open, int close) {
        if (open == 0 && close == 0) {
            lst.add(str);
            return;
        }
        if (open != 0) helper(str + "(", open - 1, close);
        if (close > open) helper(str + ")", open, close - 1);
    }
}
