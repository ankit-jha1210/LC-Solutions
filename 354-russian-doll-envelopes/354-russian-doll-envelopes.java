class Solution {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        List<Integer> lst = new ArrayList<>();
        int len = 0;
        for (int envelope[] : envelopes) {
            if (len == 0 || envelope[1] > lst.get(lst.size() - 1)) {
                lst.add(envelope[1]);
                len++;
            } else {
                int idx = ceil(lst, 0, lst.size() - 1, envelope[1]);
                lst.set(idx, envelope[1]);
            }
        }
        return len;
    }

    int ceil(List<Integer> lst, int i, int j, int x) {
        int ans = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (lst.get(mid) == x) return mid; else if (lst.get(mid) > x) {
                ans = mid;
                j = mid - 1;
            } else i = mid + 1;
        }
        return ans;
    }
}
