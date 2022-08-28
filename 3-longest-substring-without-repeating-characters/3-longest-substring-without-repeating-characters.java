class Solution {

    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        int maxi = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = sb.indexOf(ch + "");
            if (idx != -1) {
                sb.delete(0, idx + 1);
            }
            sb.append(ch);
            maxi = Math.max(sb.length(), maxi);
        }
        return maxi;
    }
}
