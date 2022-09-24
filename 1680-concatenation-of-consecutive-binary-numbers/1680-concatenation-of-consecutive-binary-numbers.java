class Solution {
    final int mod = (int) Math.pow(10, 9) + 7;

    int no_bits(int n) {
        return (int)(Math.log(n) / Math.log(2)) + 1;
    }

    public int concatenatedBinary(int n) {
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int bits = no_bits(i);
            ans = ((ans << bits) % mod + i) % mod;
        }
        return (int)ans;
    }
}
