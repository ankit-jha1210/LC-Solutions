class Solution {

    public int countBinarySubstrings(String s) {
        List<Integer> temp = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) j++;
            temp.add(j - i);
            i = j;
        }
        int ans = 0;
        for (i = 1; i < temp.size(); i++) {
            ans += Math.min(temp.get(i), temp.get(i - 1));
        }
        return ans;
    }
}
