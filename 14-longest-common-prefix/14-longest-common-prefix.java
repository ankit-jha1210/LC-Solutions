class Solution {

    public String longestCommonPrefix(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : strs) {
            for (int i = 0; i < s.length(); i++) {
                String temp = s.substring(0, i + 1);
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        String res = "";
        for(String s: map.keySet()) {
            int freq = map.get(s);
            if(freq == strs.length && s.length() > res.length()) {
                res = s;
            }
        }
        return res;
    }
}
