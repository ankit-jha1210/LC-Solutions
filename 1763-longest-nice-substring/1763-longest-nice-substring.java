class Solution {

    public String longestNiceSubstring(String s) {
        //         use hashset and check if that strings upper and lower are present or not
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (temp.length() > 1 && temp.length() > res.length() && checkNice(temp)) res = temp;
            }
        }
        return res;
    }

    boolean checkNice(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) set.add(c);
        for (char c : s.toCharArray()) {
            if (!set.contains(Character.toLowerCase(c)) || !set.contains(Character.toUpperCase(c))) return false;
        }
        return true;
    }
}
