class Solution {

    public boolean isIsomorphic(String s, String t) {
        //         one to one mapping
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) return false;
            } else {
                if (set.contains(c2)) return false;
                set.add(c2);
                map.put(c1, c2);
            }
        }
        return true;
    }
}
