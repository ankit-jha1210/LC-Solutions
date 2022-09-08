class Solution {
    public int minBitFlips(int start, int goal) {
        return countBits(start ^ goal);
    }
    
    int countBits(int x) {
        int cnt = 0;
        while(x != 0) {
            cnt++;
            x = (x & x-1);
        }
        return cnt;
    }
}