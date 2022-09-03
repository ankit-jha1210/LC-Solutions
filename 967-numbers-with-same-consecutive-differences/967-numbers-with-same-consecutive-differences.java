class Solution {

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n - 1, k, res);
        }
        int[] arr = new int[res.size()];
        int i = 0;
        for (int x : res) arr[i++] = x;
        return arr;
    }

    void dfs(int num, int n, int k, List<Integer> res) {
        if (n == 0) {
            res.add(num);
            return;
        }
        int last = num % 10;
        if (last + k <= 9) {
            dfs(num * 10 + last + k, n - 1, k, res);
        }
        if (k != 0 && last >= k) {
            dfs(num * 10 + last - k, n - 1, k, res);
        }
    }
}
