class Solution {

    public String reverseWords(String s) {
        Stack<String> stk = new Stack<>();
        String temp = "", ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (temp.length() > 0) {
                    stk.push(temp);
                    temp = "";
                }
            } else {
                temp = temp + s.charAt(i);
            }
        }
        ans += temp;
        while (!stk.isEmpty()) ans = ans + " "+ stk.pop();
        while (ans.length() != 0 && ans.charAt(0) == ' ') ans = ans.substring(1);
        return ans;
    }
}
