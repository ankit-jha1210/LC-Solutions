class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        solve(root, targetSum, new ArrayList<>());
        return res;
    }

    void solve(TreeNode root, int target, List<Integer> lst) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                lst.add(root.val);
                res.add(new ArrayList<>(lst));
                lst.remove(lst.size() - 1);
                return;
            }
        }

        lst.add(root.val);
        solve(root.left, target - root.val, lst);
        solve(root.right, target - root.val, lst);
        lst.remove(lst.size() - 1);
    }
}
