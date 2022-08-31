class Solution {

    public String longestCommonPrefix(String[] strs) {
        String s = strs[0];
        StringBuilder sb = new StringBuilder();
        outer:for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || s.charAt(i) != strs[j].charAt(i)) 
                    break outer;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
