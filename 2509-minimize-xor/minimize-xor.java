class Solution {

    public int minimizeXor(int num1, int num2) {
        int bits = countSetBits(num2);
        int ans = 0;
        int i;
        for (i = 31; i >= 0; i--) {
            int mask = (1 << i);
            if ((num1 & mask) != 0) {
                if (bits != 0) {
                    ans |= mask;
                    bits--;
                }
            } else {
                if (bits > i) {
                    ans |= mask;
                    bits--;
                }
            }
        }

        return ans;
    }

    int countSetBits(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n = (n & (n - 1));
        }
        return cnt;
    }
}
