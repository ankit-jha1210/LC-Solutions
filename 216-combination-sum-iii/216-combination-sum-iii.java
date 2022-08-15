class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        helper(k, n, 1, new ArrayList<>());
        return res;
    }

    void helper(int k, int target, int start, List<Integer> temp) {
        if (k == 0) {
            if (target == 0) res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= 9 && i <= target; i++) {
            temp.add(i);
            helper(k - 1, target - i, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
