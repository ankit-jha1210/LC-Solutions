class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        solve(s, 0, temp, res);
        return res;
    }

    void solve(String s, int ind, List<String> temp, List<List<String>> res) {
        if (ind == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = ind; i < s.length(); i++) {
            if (isPalindrome(s, ind, i)) {
                temp.add(s.substring(ind, i + 1));
                solve(s, i + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
