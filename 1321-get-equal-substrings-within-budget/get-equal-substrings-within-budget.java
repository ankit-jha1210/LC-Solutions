class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        // max window with sum <= k
        int i = 0, j = 0;
        int sum = 0, len = 0;
        while(j < s.length()) {
            sum += Math.abs(s.charAt(j) - t.charAt(j));
            while(sum > maxCost) {
                sum -= Math.abs(s.charAt(i) - t.charAt(i));
                i++; 
            }
            len = Math.max(len, j - i + 1);
            j++;
        }
        return len;
    }
}