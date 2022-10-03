class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            int num = i, cnt = 0;
            while(num > 0) {
                cnt++;
                num &= num - 1;
            }
            res[i] = cnt;
        }
        return res;
    }
}