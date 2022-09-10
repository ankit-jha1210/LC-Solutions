class Solution {

    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        int maxi = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = sb.indexOf(ch+"");
            if (index != -1) {
                sb.delete(0, index + 1);
            }
            sb.append(ch);
            maxi = Math.max(maxi, sb.length());
        }
        return maxi;
    }
}
