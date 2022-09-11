class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> lst = new ArrayList<Integer>();
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int i = 0, j = 0;
        int cnt = map.size();
        while (j < s.length()) {
            char ch1 = s.charAt(j);
            if (map.containsKey(ch1)) {
                int occurence = map.get(ch1) - 1;
                if (occurence == 0) cnt--;
                map.put(ch1, occurence);
            }
            if (j - i + 1 < p.length()) j++; else {
                if (cnt == 0) lst.add(i);
                char ch2 = s.charAt(i);
                if (map.containsKey(ch2)) {
                    int occurence = map.get(ch2) + 1;
                    if (occurence == 1) cnt++;
                    map.put(ch2, occurence);
                }
                i++;
                j++;
            }
        }
        return lst;
    }
}
