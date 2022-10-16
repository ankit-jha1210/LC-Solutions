class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] res = new int[n];
        res[0] = pref[0];
        for(int idx = 1; idx < n; idx++){
            int upperNumber = pref[idx - 1];
            int curr = pref[idx];
            int ans = 0;
            for(int i = 31; i >= 0; i--) {
                int mask = 1 << i;
                int bit = (upperNumber & mask) != 0 ? 1 : 0;
                if((curr & mask) != 0) {
                    ans |= ((1 - bit) << i);
                }
                else {
                    if(bit == 1) ans |= mask;
                }
            }
            res[idx] = ans;
        }
        return res;
    }
}