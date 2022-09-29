class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()) {
            while(i < s.length() && s.charAt(i) != '*') sb.append(s.charAt(i++));
            while(i< s.length() && sb.length() > 0 && s.charAt(i) == '*') {
                sb.delete(sb.length() - 1, sb.length());
                i++;
            }
            while(i< s.length() && s.charAt(i) == '*') i++;
        }
        return sb.toString();
    }
}