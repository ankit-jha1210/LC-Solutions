class Solution {

    public String reverseWords(String s) {
        int i = s.length() - 1;
        String ans = "";
        while (i >= 0) {
            // removing trailing spaces
            while (i >= 0 && s.charAt(i) == ' ') i--;
            if (i < 0) break;
            int j = i;
            // finding starting of a word
            while (i >= 0 && s.charAt(i) != ' ') i--;
            if (ans.length() == 0) ans = ans.concat(s.substring(i + 1, j + 1)); 
            else ans = ans.concat(" " + s.substring(i + 1, j + 1));
        }
        return ans;
    }
}
