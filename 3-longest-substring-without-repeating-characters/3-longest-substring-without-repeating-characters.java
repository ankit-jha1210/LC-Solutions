class Solution {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int maxLen = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() == j - i + 1) {
                maxLen = Math.max(maxLen, map.size());
                j++;
            } else {
                while (map.size() < j - i + 1) {
                    char ch = s.charAt(i);
                    int occurence = map.get(ch) - 1;
                    if (occurence == 0) map.remove(ch);
                    else map.put(ch, occurence);
                    i++;
                }
                j++;
            }
        }
        return maxLen;
    }
}
