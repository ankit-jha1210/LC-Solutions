class Solution {

    public int countPrimes(int n) {
        if (n <= 1) return 0;
        boolean[] notPrime = new boolean[n];
        notPrime[0] = notPrime[1] = true;
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                cnt++;
                for (int j = 2 * i; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        return cnt;
    }
}
