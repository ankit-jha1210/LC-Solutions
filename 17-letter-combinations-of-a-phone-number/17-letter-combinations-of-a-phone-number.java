class Solution {
    String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        return letterCombinations(digits, 0);
    }

    public List<String> letterCombinations(String digits, int ind) {
        List<String> res = new ArrayList<>();
        if (ind == digits.length()) {
            res.add("");
            return res;
        }
        List<String> small = letterCombinations(digits, ind + 1);
        int digit = digits.charAt(ind) - '0';
        String str = map[digit];
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < small.size(); j++) {
                String newStr = str.charAt(i) + small.get(j);
                res.add(newStr);
            }
        }
        return res;
    }
}
