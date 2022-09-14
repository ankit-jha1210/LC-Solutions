class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int maxLen = 0;
        while(j < s.length()) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if(map.size() == j - i + 1) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            else {
                while(map.size() < j - i + 1) {
                    int occurence = map.get(s.charAt(i)) - 1;
                    if(occurence == 0) map.remove(s.charAt(i));
                    else map.put(s.charAt(i), occurence);
                    i++;
                }
            }
            j++;
        }
        return maxLen;
    }
}