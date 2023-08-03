class Solution {

    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLen = Math.max(maxLen, set.size());
            } else set.remove(s.charAt(i++));
        }
        return maxLen;
    }
}
