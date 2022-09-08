class Solution {
    public int minBitFlips(int start, int goal) {
        int res = 0;
        for(int i = 31; i >= 0; i--) {
            int bit1 = (start & (1 << i)) != 0 ? 1: 0;
            int bit2 = (goal & (1 << i)) != 0 ? 1: 0;
            if(bit1 != bit2) res++;
        }
        return res;
    }
}