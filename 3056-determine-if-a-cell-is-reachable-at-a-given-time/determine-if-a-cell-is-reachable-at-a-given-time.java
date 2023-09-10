class Solution {

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int d1 = Math.abs(fx - sx);
        int d2 = Math.abs(fy - sy);

        int ans = Math.max(d1, d2);

        if (t == 1 && ans == 0) return false;

        return ans <= t;
    }
}
