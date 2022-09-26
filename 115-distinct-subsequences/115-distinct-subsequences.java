class Solution {

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] prev = new int[n + 1];
        prev[0] = 1;
        for (int i = 1; i <= m; i++) {
            int[] curr = new int[n + 1];
            curr[0] = 1;
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + prev[j];
                } else curr[j] = prev[j];
            }
            prev = curr;
        }
        return prev[n];
    }

}
