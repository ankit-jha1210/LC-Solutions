
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        solve(root, lst);
        return lst;
    }
    void solve(TreeNode root, List<Integer> lst) {
        if(root == null) return;
        solve(root.left, lst);
        lst.add(root.val);
        solve(root.right, lst);
    }
}