class Solution {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        String res = "";
        int minLen = Integer.MAX_VALUE;
        int cnt = map.size();
        int i = 0, j = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                int occurence = map.get(ch) - 1;
                if (occurence == 0) cnt--;
                map.put(ch, occurence);
            }
            while (cnt == 0) {
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
                char c2 = s.charAt(i);
                if (map.containsKey(c2)) {
                    int occurence = map.get(c2) + 1;
                    if (occurence == 1) cnt++;
                    map.put(c2, occurence);
                }
                i++;
            }
            j++;
        }
        return res;
    }
}
