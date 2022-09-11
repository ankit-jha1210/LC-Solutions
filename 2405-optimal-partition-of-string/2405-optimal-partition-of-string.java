class Solution {

    public int partitionString(String s) {
        int[] letters = new int[26];
        int i = 0, res = 1;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (letters[ch - 'a'] != 0) {
                Arrays.fill(letters, 0);
                res++;
            }
            letters[ch - 'a']++;
            i++;
        }
        return res;
    }
}
