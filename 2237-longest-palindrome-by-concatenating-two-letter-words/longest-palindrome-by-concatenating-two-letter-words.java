class Solution {

    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        boolean isCentral = false;
        int cnt = 0;
        for (String key : map.keySet()) {
            int freq = map.get(key);
            if (key.charAt(0) == key.charAt(1)) {
                if (freq % 2 == 0) cnt += 2 * freq; 
                else {
                    cnt += 2 * (freq - 1);
                    isCentral = true;
                }
            } else {
                String rev = key.charAt(1) + "" + key.charAt(0);
                if (map.containsKey(rev)) {
                    int min = Math.min(freq, map.get(rev));
                    cnt += 4 * min;
                }
            }
            map.put(key, 0);
        }
        if (isCentral) cnt += 2;
        return cnt;
    }
}
