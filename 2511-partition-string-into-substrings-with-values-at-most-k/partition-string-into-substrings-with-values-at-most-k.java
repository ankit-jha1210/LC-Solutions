class Solution {
    public int minimumPartition(String s, int k) {
        int i = 0;
        int cnt = 0;
        while(i < s.length()) {
            int j = i + 1;
            while(j < s.length() && Long.parseLong(s.substring(i, j + 1)) <= k) j++;
            if(Long.parseLong(s.substring(i, j)) > k) return -1;
            cnt++;
            i = j;
        }
        return cnt;
    }
}