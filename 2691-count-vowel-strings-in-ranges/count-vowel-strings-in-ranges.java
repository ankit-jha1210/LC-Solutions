class Solution {

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            int len = words[i].length();
            prefix[i] = (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(len - 1))) ? 1 : 0;
            if (i > 0) prefix[i] += prefix[i - 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            res[i] = prefix[r];
            if (l > 0) res[i] -= prefix[l - 1];
        }
        return res;
    }

    boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
