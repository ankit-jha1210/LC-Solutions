class Solution {

    public String shiftingLetters(String s, int[][] nums) {
        StringBuilder sb = new StringBuilder(s);
        int[] freq = new int[s.length() + 1];
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i][0];
            int end = nums[i][1];
            int val = nums[i][2] == 1 ? 1 : -1;
            freq[start] += val;
            freq[end + 1] -= val;
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += freq[i];
            int newChar = (sb.charAt(i) - 'a' + sum) % 26;
            if (newChar < 0) newChar += 26;
            char ch = (char) ('a' + newChar);
            sb.setCharAt(i, ch);
        }
        return sb.toString();
    }
}
