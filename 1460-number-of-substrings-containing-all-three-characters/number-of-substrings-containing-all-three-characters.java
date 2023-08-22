class Solution {
    public int numberOfSubstrings(String s) {
         int i = 0, j = 0, ans = 0;
       HashMap<Character, Integer> map = new HashMap<>();
       while(j < s.length()) {
           char c = s.charAt(j);
           map.put(c, map.getOrDefault(c, 0) + 1);
           while(map.size() == 3) {
               c = s.charAt(i);
               int freq = map.get(c) - 1;
               if(freq == 0) map.remove(c);
               else map.put(c, freq);
               ans += s.length() - j;
               i++;
           }
           j++;
       }
       return ans;
    }
}