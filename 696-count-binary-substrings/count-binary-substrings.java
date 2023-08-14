class Solution {

    public int countBinarySubstrings(String s) {
        int[] zero = new int[s.length()];
        int[] one = new int[s.length()];
        if (s.charAt(0) == '0') zero[0] = 1; else one[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') zero[i] = zero[i - 1] + 1; else one[i] = one[i - 1] + 1;
        }
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                int idx = i - zero[i];
                if (idx >= 0) {
                    if (one[idx] >= zero[i]) cnt++;
                }
            } else {
                int idx = i - one[i];
                if (idx >= 0) {
                    if (zero[idx] >= one[i]) cnt++;
                }
            }
        }
        return cnt;
    }
}
