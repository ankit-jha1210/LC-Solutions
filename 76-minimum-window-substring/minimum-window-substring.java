class Solution {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        int i = 0, j = 0;
        int len = Integer.MAX_VALUE;
        String ans = "";
        int cnt = map.size();
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                int freq = map.get(ch) - 1;
                if (freq == 0) cnt--;
                map.put(ch, freq);
            }

            while (cnt == 0) {
                ch = s.charAt(i);
                if (map.containsKey(ch)) {
                    if (j - i + 1 < len) {
                        ans = s.substring(i, j + 1);
                        len = j - i + 1;
                    }
                    int freq = map.get(ch) + 1;
                    if (freq == 1) cnt++;
                    map.put(ch, freq);
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}
